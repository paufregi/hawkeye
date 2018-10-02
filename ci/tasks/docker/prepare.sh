#!/bin/sh

WORKING_FOLDER=$( pwd )

cp repo/$DOCKERFILE_PATH docker-src

cp artifact/${NAME}*.jar docker-src/${NAME}.jar
