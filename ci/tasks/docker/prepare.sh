#!/bin/sh

WORKING_FOLDER=$( pwd )

cp repo/$DOCKERFILE_PATH docker-src

mkdir docker-src/target
cp artifact/${NAME}*.jar docker-src/target/${NAME}.jar

echo "Docker will build the image and push on ECR - not doing it cause running Concourse locally in a docker"
