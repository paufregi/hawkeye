#!/bin/bash

WORKING_FOLDER=$( pwd )
IVY_FOLDER="$WORKING_FOLDER/.ivy2"
SOURCE_FOLDER="repo/$SRC_PATH"
ARTIFACT_FOLDER="$WORKING_FOLDER/artifact"
VERSION=$(cat version/version)

cd "$SOURCE_FOLDER"
sbt -ivy "$IVY_FOLDER" clean test assembly

cd target
for f in *.jar; do
    cp "$f" "$ARTIFACT_FOLDER/${f%.jar}-$VERSION.jar";
done
