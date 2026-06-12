//package com.project.parkIQ.security;
//
//import com.nimbusds.oauth2.sdk.auth.JWTAuthentication;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@
//public class JwtAuthenticationFilter {
//    @Autowired
//    private JWTAuthentication jwtAuthentication;
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.csrf(csrf->csrf.disable()).sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authorizeHttpRequests(auth->auth.requestMatchers("/auth/**").permitAll().requestMatchers().permitAll().anyRequest().authenticated()).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//                return http.build();
//    }
//}
