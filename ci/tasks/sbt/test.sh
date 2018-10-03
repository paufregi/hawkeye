#!/bin/bash

WORKING_FOLDER=$( pwd )

cd "repo/$SRC_PATH"
sbt -ivy "$WORKING_FOLDER/.ivy2" "project $PROJECT" clean compile test
