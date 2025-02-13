package com.topicos.auth;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    private final JwtGrantedAuthoritiesConverter defaultGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

    @Autowired
    private ObjectMapper objectMapper;
    
    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = Stream
                .concat(defaultGrantedAuthoritiesConverter.convert(jwt).stream(),
                        extractAuthorities(jwt).stream())
                .collect(Collectors.toSet());
        authorities.stream().forEach(System.out::println); // Para depuração
        return new JwtAuthenticationToken(jwt, authorities, jwt.getClaimAsString("preferred_username"));
    }

    private Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
        Set<String> rolesWithPrefix = new HashSet<>();
        rolesWithPrefix.addAll(getRealmRoles(jwt));
        rolesWithPrefix.addAll(getResourceRoles(jwt));
        return AuthorityUtils.createAuthorityList(rolesWithPrefix.toArray(new String[0]));
    }

    private Set<String> getRealmRoles(Jwt jwt) {
        Set<String> rolesWithPrefix = new HashSet<>();
        JsonNode json = objectMapper.convertValue(jwt.getClaim("realm_access"), JsonNode.class);
        if (json != null && json.has("roles")) {
            json.get("roles").forEach(r -> rolesWithPrefix.add(createRole(r.asText())));
        }
        return rolesWithPrefix;
    }

    private Set<String> getResourceRoles(Jwt jwt) {
        Set<String> rolesWithPrefix = new HashSet<>();
        Map<String, JsonNode> map = objectMapper.convertValue(jwt.getClaim("resource_access"), new TypeReference<Map<String, JsonNode>>(){});
        if (map != null) {
            for (Map.Entry<String, JsonNode> jsonNode : map.entrySet()) {
                String client = jsonNode.getKey();
                JsonNode clientRoles = jsonNode.getValue().get("roles");
                if (clientRoles != null) {
                    clientRoles.forEach(r -> rolesWithPrefix.add(createRole(client, r.asText())));
                }
            }
        }
        return rolesWithPrefix;
    }

    private String createRole(String... values) {
        StringBuilder role = new StringBuilder("ROLE_");
        for (int i = 0; i < values.length; i++) {
            role.append(values[i].toUpperCase());
            if (i < values.length - 1) {
                role.append("_");
            }
        }
        return role.toString();
    }
}
