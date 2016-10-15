@REM Clean up docker machine containers and images

@setlocal EnableDelayedExpansion

@REM Clean up old docker containers
@ECHO Cleaning old containers
@FOR /F %%I IN ('docker ps -a -q') DO @(
@ECHO Removing container %%I
@CALL docker rm %%I
)

@REM Clean up orphaned docker images
@ECHO Cleaning old images
@FOR /F "tokens=3" %%I IN ('docker images ^| FindStr "<none>"') DO @(
@ECHO Removing image %%I
@CALL docker rmi %%I
)

@ECHO Done.
