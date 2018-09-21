#!/bin/bash

cp -r repo/${SRC_PATH}/${NAME} /src/${NAME}

cd /src/${NAME}
sbt clean compile test
