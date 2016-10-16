#!/bin/bash

###############################################################################
#
# Usage:
# ./wait-for-service.sh $health-service-url [-- command args]
#
# Example:
#  ./wait-for-service.sh http://config-service:8888/health -- echo "DONE"
#
###############################################################################

HEALTH_SERVICE_URL="$1"

if [[ $2 == "--" ]]; then
    shift 2
    COMMAND="$@"
fi

echo "Waiting for endpoint $HEALTH_SERVICE_URL"

while [ -z ${DISCOVERY_SERVICE_READY} ]; do
  echo "Waiting for endpoint $HEALTH_SERVICE_URL"
  if [ "$(curl --silent $HEALTH_SERVICE_URL 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
      DISCOVERY_SERVICE_READY=true;
  fi
  sleep 2
done

if [[ $COMMAND != "" ]]; then
    echo "Executing command $COMMAND"
    exec $COMMAND
else
    exit 0
fi
