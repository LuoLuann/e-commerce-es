FROM quay.io/keycloak/keycloak:latest

# Mudar para usuário root para alterar permissões
USER root

# Copiar o script de entrypoint para o container
COPY keycloak-entrypoint.sh /opt/keycloak/keycloak-entrypoint.sh

# Dar permissão de execução ao script
RUN chmod +x /opt/keycloak/keycloak-entrypoint.sh

# Mudar de volta para o usuário padrão do Keycloak
USER keycloak

# Definir o entrypoint personalizado
ENTRYPOINT ["/opt/keycloak/keycloak-entrypoint.sh"]
