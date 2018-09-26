#!/bin/bash

WORKING_FOLDER=$( pwd )
IVY_FOLDER="$WORKING_FOLDER/.ivy2"
SOURCE_FOLDER="repo/$SRC_PATH"

cd "$SOURCE_FOLDER"

sbt -ivy "$IVY_FOLDER" clean compile test
