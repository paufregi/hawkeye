#!/bin/bash

WORKING_FOLDER=$( pwd )
ARTIFACT_FOLDER="$WORKING_FOLDER/artifact"
IVY_FOLDER="$WORKING_FOLDER/.ivy2"
VERSION=$(cat version/version)

cd repo
sbt -ivy "$IVY_FOLDER" clean test assembly

cd target
for f in *.jar; do
    cp "$f" "$ARTIFACT_FOLDER/${f%.jar}-$VERSION.jar";
done
