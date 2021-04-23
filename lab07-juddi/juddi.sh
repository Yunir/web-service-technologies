#!/usr/bin/env bash

JUDDI_VERSION="3.3.8"

wget https://downloads.apache.org/juddi/juddi/$JUDDI_VERSION/juddi-distro-$JUDDI_VERSION.zip
unzip juddi-distro-$JUDDI_VERSION.zip
juddi-distro-3.3.8/juddi-tomcat-3.3.8/bin/startup.sh