package com.nva.server.configs;

import com.nva.server.filters.CustomAccessDeniedHandler;
import com.nva.server.filters.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
                    auth.requestMatchers("/api/v1/stats/**").hasRole("ADMIN");
                    auth.anyRequest().authenticated();
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler()).and()
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
                .formLogin().defaultSuccessUrl("/admin/", true).failureUrl("/login?error").and()
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler()).and().build();
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
