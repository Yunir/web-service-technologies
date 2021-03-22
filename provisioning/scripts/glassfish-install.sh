#!/usr/bin/env bash
set -ex

# prerequisites
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update
sudo apt-get install -y openjdk-8-jdk unzip
echo "export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64" >> ~/.bashrc
echo "export PATH=\$JAVA_HOME/bin:$PATH" >> ~/.bashrc

pushd /tmp
wget https://rhlx01.hs-esslingen.de/pub/Mirrors/eclipse/glassfish/glassfish-5.1.0.zip
unzip glassfish-5.1.0.zip && rm glassfish-5.1.0.zip
sudo mv glassfish5 /usr/lib/glassfish
echo "export PATH=/usr/lib/glassfish/bin:$PATH" >> ~/.bashrc
popd
