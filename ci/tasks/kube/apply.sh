#!/bin/sh

apk add --update curl gettext > /dev/null
TAG="$(cat version/version)"

cat "repo/${TEMPLATE}" | envsubst '${TAG}' > kube-file.yaml

echo kube-file.yaml
cat kube-file.yaml
