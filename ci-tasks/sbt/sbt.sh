#!/bin/bash

export WORKING_FOLDER=$( pwd )
export COURSIER_CACHE="$WORKING_FOLDER/.coursier"

cat <<EOF > "${WORKING_FOLDER}/repositories"
[repositories]
  local
  maven-central
  typesafe-ivy-releases: http://repo.typesafe.com/typesafe/ivy-releases/, [organization]/[module]/[revision]/[type]s/[artifact](-[classifier]).[ext], bootOnly
  sonatype-snapshots: https://oss.sonatype.org/content/repositories/snapshots
  google-maven-central-mirror: https://maven-central.storage.googleapis.com/repos/central/data/
EOF

export SBT_OPTS="-Xms512M -Xmx2048M -Xss2M -XX:MaxMetaspaceSize=1024M"

cd "repo/${SRC_PATH}"


echo "sbt ${SBT_COMMANDS} \ "
echo "-ivy \"$WORKING_FOLDER/.ivy2\" \ "
echo "-Dsbt.global.base=\"$WORKING_FOLDER/.sbt/1.0\" \ "
echo "-Dsbt.repository.config=\"$WORKING_FOLDER/repositories\" \ "

sbt ${SBT_COMMANDS} \
-ivy "$WORKING_FOLDER/.ivy2" \
-Dsbt.global.base="$WORKING_FOLDER/.sbt/1.0" \
-Dsbt.repository.config="$WORKING_FOLDER/repositories" \

