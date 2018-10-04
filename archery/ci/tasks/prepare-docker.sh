#!/bin/sh

WORKING_FOLDER=$( pwd )

cp repo/$DOCKERFILE_PATH docker-src

cp repo/$SRC_PATH/*.py docker-src

cd $WORKING_FOLDER
ls -la docker-src/*
echo ""
echo "Docker will build the image and push on ECR - not doing it cause running Concourse locally in a docker"
