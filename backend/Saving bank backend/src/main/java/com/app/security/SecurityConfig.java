package com.app.security;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@SecurityScheme(
    name = "BasicAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "basic"
)
public class SecurityConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//            .cors(cors -> cors.configurationSource(corsConfigurationSource()))  // ✅ Enable CORS for all origins
            .csrf(csrf -> csrf.disable())  // ✅ Disable CSRF (not needed for REST APIs)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()  // ✅ Allow all requests without authentication
            )
            .httpBasic(Customizer.withDefaults())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }


//    @Bean
//    public SecurityFilterChain authorizeRequests(HttpSecurity http) throws Exception {
//        http.csrf(customizer -> customizer.disable())
//            .authorizeHttpRequests(request -> 
//                request.requestMatchers(
//                    "/user/login", 
//                    "/manager/login",
//                    "/products/view", 
//                    "/users/signup", 
//                    "/users/signin",
//                    "/user/add",
//                    "/user/view",
//                    "/user/**",
//                    "/accounts/**",
//                    "/swagger-ui/**",
//                    "/v3/api-docs/**",
//                    "/swagger-resources/**",
//                    "/v2/api-docs/**",
//                    "/webjars/**"
//                ).permitAll()
//                .requestMatchers("/products/purchase/**").hasRole("CUSTOMER")
//                .requestMatchers("/products/add", "/products/delete").hasRole("ADMIN")
//                .anyRequest().authenticated()
//            )
//            .httpBasic(Customizer.withDefaults())
//            .sessionManagement(session -> 
//                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        
//        return http.build();
    
}