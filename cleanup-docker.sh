#!/bin/bash

# Clean up docker machine containers and images

# Clean up old docker containers
_OLD_CONTAINERS="$(docker ps -a -q)"
if [[ -z ${_OLD_CONTAINERS} ]] 
then
    echo "No old containers to remove"
else
    echo "Removing old container images"
    docker rm ${_OLD_CONTAINERS}
fi

# Clean up orphaned docker images
_OLD_IMAGES="$(docker images | grep '^<none>' | awk '{print $3}')"
if [[ -z ${_OLD_IMAGES} ]]
then
    echo "No orphaned images to remove"
else
    echo "Removing orphaned docker images"
    docker rmi ${_OLD_IMAGES}
fi