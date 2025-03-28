#!/bin/sh

# Replace environment variables in the config file
#envsubst < /etc/alertmanager/alertmanager.yml > /tmp/alertmanager.yml
sed "s|\$ALERTMANAGER_TO_EMAIL|$ALERTMANAGER_TO_EMAIL|g" /etc/alertmanager/alertmanager.yml | \
  sed "s|\$ALERTMANAGER_AUTH_USERNAME|$ALERTMANAGER_AUTH_USERNAME|g" | \
  sed "s|\$ALERTMANAGER_AUTH_PASSWORD|$ALERTMANAGER_AUTH_PASSWORD|g" > /tmp/alertmanager.yml

# Run Alertmanager with the processed config file
exec /bin/alertmanager --config.file=/tmp/alertmanager.yml