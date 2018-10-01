#!/bin/sh

WORKING_FOLDER=$( pwd )

cp "repo/$DOCKERFILE" docker-src/

if [ -z $RESOURCES ]; then
    cp "repo/$RESOURCES" docker-src/
fi

cp "artifact/${NAME}*.jar" docker-src/${NAME}.jar
