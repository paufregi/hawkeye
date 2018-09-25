#!/bin/bash

export WORKING_FOLDER=$( pwd )

cd repo

sbt -ivy $WORKING_FOLDER/.ivy2 clean assembly

ls -la target/scala-2.12/hawkeye.jar
