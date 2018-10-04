#!/bin/bash

VERSION=$(cat version/version)

echo "Docker image $VERSION tagged as $ENV"
echo "Rundeck update"
echo "Trigger Rundeck"