#!/usr/bin/env bash

set -euxo pipefail

# prerequisites
#add-apt-repository ppa:openjdk-r/ppa
#apt-get update
#apt-get install -y unzip openjdk-11-jdk

# JUDDI_VERSION="3.3.3"

# wget https://archive.apache.org/dist/juddi/juddi/$JUDDI_VERSION/juddi-distro-$JUDDI_VERSION.zip
# unzip juddi-distro-$JUDDI_VERSION.zip
# juddi-distro-$JUDDI_VERSION/juddi-tomcat-$JUDDI_VERSION/bin/startup.sh

# OR use docker-image
docker run -v $(pwd):/lab07 --rm -dp 8989:8080 -p 8888:8081 --name web-service-tech-lab07 ericcong/juddi:3.3.3
docker exec -it web-service-tech-lab07 /bin/bash

# DO THIS on host machine (for lab03)
# mvn package
# --
# apt update
# apt install -y maven
# --
cd /lab07/lab03-server-side
$JAVA_HOME/bin/java -jar target/lab03-server-side-2.3.jar

# Debian 8 does not have jdk1.8 - it is not necessary if packaged on labstation
# java -jar target/lab03-server-side-2.0.jar
# apt-get install software-properties-common
# add-apt-repository "deb http://ppa.launchpad.net/webupd8team/java/ubuntu xenial main"
# apt-get update
