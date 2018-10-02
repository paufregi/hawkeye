#!/bin/bash

WORKING_FOLDER=$( pwd )
VERSION=$(cat version/version)

cd "repo/$SRC_PATH"
sbt -ivy "$WORKING_FOLDER/.ivy2" "project $PROJECT"clean test assembly

cd target
for f in *.jar; do
    cp "$f" "$WORKING_FOLDER/artifact/${f%.jar}-$VERSION.jar";
done
