package com.nva.server.configs;

import com.nva.server.enums.Role;
import com.nva.server.filters.JwtAuthenticationFilter;
import com.nva.server.pojos.User;
import com.nva.server.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

//        http.formLogin()
//                .usernameParameter("email")
//                .passwordParameter("password");
//
//        http.formLogin().defaultSuccessUrl("/")
//                .failureUrl("/login?error");
//
//        http.logout().logoutSuccessUrl("/login");
//        http.exceptionHandling()
//                .accessDeniedPage("/login?accessDenied");
//
//        http.authorizeRequests().requestMatchers("/")
//                .access("hasRole('ROLE_ADMIN')");
//        http.csrf().disable();

        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/api/v1/auth/**").permitAll()
                .requestMatchers("/api/v1/users").access("isAuthenticated() and hasRole('ROLE_ADMIN')")
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public CommandLineRunner run(UserService userService) {
//        User user1 = User.builder()
//                .firstName("Đạt")
//                .lastName("Lương Tấn")
//                .email("dat@ou.edu.vn")
//                .password("1234")
//                .role(Role.ROLE_ADMIN)
//                .enabled(true)
//                .locked(false).build();
//        User user2 = User.builder()
//                .firstName("Duy")
//                .lastName("Lê Trần Nhật")
//                .email("duy@gmail.com")
//                .password("1234")
//                .role(Role.ROLE_USER)
//                .enabled(true)
//                .locked(false).build();
//        return args -> {
//            userService.addNewUser(user1);
//            userService.addNewUser(user2);
//        };
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.build();
    }
}
