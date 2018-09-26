#!/bin/bash

WORKING_FOLDER=$( pwd )
IVY_FOLDER="$WORKING_FOLDER/.ivy2"

cd repo

sbt -ivy "$IVY_FOLDER" clean compile test
