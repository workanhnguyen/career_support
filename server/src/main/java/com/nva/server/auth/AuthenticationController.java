package com.nva.server.auth;

import com.nva.server.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserRegisterRequest request) {
        int response = authenticationService.register(request);
        switch (response) {
            case -1:
                return new ResponseEntity("Unknown error", HttpStatus.INTERNAL_SERVER_ERROR);
            case 0:
                return new ResponseEntity("Email taken", HttpStatus.NOT_ACCEPTABLE);
            case 1:
                return new ResponseEntity("Register successfully!", HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
        if (userService.findByEmail(request.getEmail()) != null)
            return ResponseEntity.ok(authenticationService.authenticate(request));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @GetMapping("/confirm")
    public String confirm(@RequestParam(name = "token") String token) {
        return authenticationService.confirmToken(token);
    }

    @PostMapping("/logout")
    public ResponseEntity<Boolean> logout(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, null, authentication);
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
