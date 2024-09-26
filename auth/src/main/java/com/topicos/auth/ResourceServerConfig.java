package com.topicos.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig {
    @Autowired
    private KeycloakJwtAuthenticationConverter keycloakJwtAuthenticationConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(
                        jwt -> jwt.jwtAuthenticationConverter(keycloakJwtAuthenticationConverter)))
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/public/**").permitAll() // Permite acesso público para qualquer rota que comece com /public
                .anyRequest().authenticated() // Requer autenticação para todas as outras requisições
            )
           
            ;
        return http.build();
    }
}
