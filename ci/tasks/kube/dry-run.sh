#!/bin/sh

apk add --update curl gettext > /dev/null
TAG="$(cat version/version)"

envsubst < "repo/${TEMPLATE}" > kube-file.yml

echo "kubectl --context --dry-run --validate -f kube-file.yml"
echo
echo "kube-file.yml"
cat kube-file.yml
