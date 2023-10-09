package com.nva.server.configs;

import com.nva.server.enums.Role;
import com.nva.server.filters.CustomAccessDeniedHandler;
import com.nva.server.filters.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.AccessController;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    @Autowired
    private  JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    @Order(1)
    public SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher(AntPathRequestMatcher.antMatcher("/api/**"))
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(AntPathRequestMatcher.antMatcher("/api/v1/auth/**")).permitAll();
                    auth.requestMatchers("/api/v1/users").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.GET, "/api/v1/hollands").permitAll();
//                    auth.requestMatchers(HttpMethod.GET, "/api/v1/surveys").authenticated();
                    auth.anyRequest().authenticated();
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(crsf -> crsf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/api/**")))
                .cors(Customizer.withDefaults())
                .build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain serverSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher(AntPathRequestMatcher.antMatcher("/**"))
                .authorizeHttpRequests(auth -> {
                    auth.anyRequest().hasRole("ADMIN");
                })
                .csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/**")))
                .formLogin().defaultSuccessUrl("/admin/", true).failureUrl("/login?error").and().build();
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
}
