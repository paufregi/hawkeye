#!/bin/bash

export WORKING_FOLDER=$( pwd )

cd repo

sbt -ivy $WORKING_FOLDER/.ivy2 clean compile test
