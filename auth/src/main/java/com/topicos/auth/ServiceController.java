package com.topicos.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;


@RestController
public class ServiceController {

    @GetMapping("/public/endpoint")
    public String publicEndpoint() {
        return "Esta é uma rota pública";
    }

    @GetMapping("/protected/endpoint")
    public String protectedEndpoint() {
        return "Esta é uma rota protegida, acessível apenas com token";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/protected/admin")
    public String adminEndpoint() {
        return "Essa rota apenas o admin pode acessar";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/protected/user")
    public String userEndpoint() {
        return "Essa rota apenas o user pode acessar";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/protected/admin/user")
    public String roleEndpoint() {
        return "Essa rota apenas o admin e user podem acessar";
    }
}