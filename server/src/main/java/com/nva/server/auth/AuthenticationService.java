package com.nva.server.auth;

import com.nva.server.configs.JwtService;
import com.nva.server.dtos.DataMailDTO;
import com.nva.server.enums.Role;
import com.nva.server.pojos.ConfirmationToken;
import com.nva.server.pojos.User;
import com.nva.server.repositories.UserRepository;
import com.nva.server.services.ConfirmationTokenService;
import com.nva.server.services.MailService;
import com.nva.server.utils.Const;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final ConfirmationTokenService confirmationTokenService;
    private final MailService mailService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;

    public int register(RegisterRequest request) {
        try {
            var user = new User();

            if (userRepository.findByEmail(request.getEmail()).isEmpty()) {
                user = User.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .role(Role.ROLE_USER)
                        .locked(false)
                        .enabled(false)
                        .createdAt(new Date())
                        .build();
            } else {
                user = modelMapper.map(userRepository.findByEmail(request.getEmail()), User.class);
            }

            if (!user.getEnabled()) {
                // TODO: Create confirmation token
                String token = UUID.randomUUID().toString();
                ConfirmationToken confirmationToken = ConfirmationToken.builder()
                        .token(token)
                        .createdAt(LocalDateTime.now())
                        .expiredAt(LocalDateTime.now().plusMinutes(15))
                        .user(user).build();
                confirmationTokenService.saveConfirmationToken(confirmationToken);

                // TODO: Send email
                String activateLink = "http://localhost:8080/server/api/v1/auth/confirm?token=" + token;

                DataMailDTO dataMail = new DataMailDTO();

                dataMail.setTo(request.getEmail());
                dataMail.setSubject(Const.SEND_MAIL_SUBJECT.CLIENT_REGISTER);

                Map<String, Object> props = new HashMap<>();
                props.put("name", request.getLastName() + " " + request.getFirstName());
                props.put("activateLink", activateLink);
                dataMail.setProps(props);

                mailService.sendHtmlMail(dataMail, Const.TEMPLATE_FILE_NAME.CLIENT_REGISTER);
                return 1;
            } else {
                return 0;
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .findByToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("Token not found"));

        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

        if (confirmationToken.getConfirmedAt() != null) {
            return "Email already confirmed";
        } else if (expiredAt.isBefore(LocalDateTime.now())) {
            return "Token expired";
        } else {
            confirmationTokenService.setConfirmedAt(token);
            userRepository.enableUser(confirmationToken.getUser().getEmail());

            return "Confirmed successfully!";
        }
    }
}
