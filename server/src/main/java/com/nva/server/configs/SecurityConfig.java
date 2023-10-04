package com.nva.server.configs;

import com.nva.server.filters.CustomAccessDeniedHandler;
import com.nva.server.filters.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private  JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors(Customizer.withDefaults())
                .authorizeRequests()
                .requestMatchers("/api/v1/auth/**").permitAll()
                .requestMatchers("/api/v1/users").access("isAuthenticated() and hasRole('ROLE_ADMIN')")
                .requestMatchers(HttpMethod.GET, "/api/v1/hollands").permitAll()
                .anyRequest().access("isAuthenticated() and hasRole('ROLE_ADMIN')")
                .and()
                .httpBasic()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/login?accessDenied")
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());

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
