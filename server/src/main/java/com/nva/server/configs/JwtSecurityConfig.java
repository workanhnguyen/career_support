package com.nva.server.configs;

import com.nva.server.filters.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
//@Order(1)
public class JwtSecurityConfig {
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private AuthenticationProvider authenticationProvider;
//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .cors(Customizer.withDefaults())
//                .authorizeRequests()
//                .requestMatchers("/api/v1/auth/**").permitAll()
//                .requestMatchers("/api/v1/users").access("isAuthenticated() and hasRole('ROLE_ADMIN')")
//                .requestMatchers(HttpMethod.GET, "/api/v1/hollands").permitAll()
//                .anyRequest().access("isAuthenticated() and hasRole('ROLE_ADMIN')")
//                .and()
//                .formLogin().loginPage("/login").defaultSuccessUrl("/home")
//                .and()
//                .logout().logoutUrl("/logout").permitAll()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());
//
//        return http.build();
//    }
}
