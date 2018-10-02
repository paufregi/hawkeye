#!/bin/sh

WORKING_FOLDER=$( pwd )

cp repo/$DOCKERFILE_PATH docker-src

mkdir docker-src/target
cp artifact/${NAME}*.jar docker-src/target/${NAME}.jar
