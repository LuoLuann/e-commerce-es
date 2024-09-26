#!/bin/bash
# Verifica se o realm já existe
if /opt/keycloak/bin/kc.sh list realms | grep -q "tees"; then
  echo "Realm 'tees' já existe, iniciando Keycloak sem importar."
else
  echo "Realm 'tees' não encontrado, importando realm-export.json."
  /opt/keycloak/bin/kc.sh import --file /opt/keycloak/realm-export.json
fi

# Inicia o Keycloak no modo dev
exec /opt/keycloak/bin/kc.sh start-dev
