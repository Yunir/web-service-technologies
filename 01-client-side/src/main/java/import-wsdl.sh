#!/usr/bin/env zsh

rm PersonService.wsdl
wget http://localhost:8080/PersonService\?wsdl -O PersonService.wsdl
wsimport -s . PersonService.wsdl