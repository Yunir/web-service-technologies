#!/usr/bin/env zsh

rm PersonService.wsdl
wget http://localhost:8080/PersonService\?wsdl -O PersonService.wsdl
# wget http://localhost:8080/lab01-server-side-j2ee-0.5.2/ws/persons\?wsdl -O PersonService.wsdl
wsimport -s . PersonService.wsdl