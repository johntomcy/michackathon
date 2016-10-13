#!/bin/bash

SERVICE_URL="$1"

echo "Waiting for endpoint $1"

while [ -z ${DISCOVERY_SERVICE_READY} ]; do
  echo "Waiting for endpoint $1"
  if [ "$(curl --silent $SERVICE_URL 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
      DISCOVERY_SERVICE_READY=true;
  fi
  sleep 2
done

echo "Starting service"
java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
