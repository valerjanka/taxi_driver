#!/bin/bash
#
# run-script
#
# USAGE: run.sh { java-parameters }
#

CUR_DIR=`pwd`
SCRIPT_DIR=`dirname $0`

BASE_DIR=${SCRIPT_DIR}/..
LIB_DIR=lib
CFG_DIR=cfg
CFG_DEFAULT=cfg/default
if [ -z "${JAVA_HOME}" ]
then
  JAVA=`which java`
else
  JAVA=${JAVA_HOME}/bin/java
fi

RDL_OPTS="-Xms128M -Xmx512M -XX:-UseSplitVerifier"

CP="${CFG_DIR}"
CP="$CP:${CFG_DEFAULT}"
for lib in `cd ${BASE_DIR} && ls ${LIB_DIR}/*.jar`; do
    CP="$CP:${lib}"
done

cd $BASE_DIR
${JAVA} ${RDL_OPTS} -cp ${CP} com.taxi.driver.server.ServerBootstrap $@
cd $CUR_DIR
