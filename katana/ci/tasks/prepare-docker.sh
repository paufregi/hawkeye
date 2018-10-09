#!/bin/sh

WORKING_FOLDER=$( pwd )

cp repo/$DOCKERFILE_PATH docker-src

mkdir docker-src/target
cp artifact/${NAME}*.jar docker-src/target/${NAME}.jar

cd $WORKING_FOLDER
ls -la docker-src/*
echo ""
echo "Docker will build the image and push on ECR - not doing it because Concourse is running locally in a docker"
