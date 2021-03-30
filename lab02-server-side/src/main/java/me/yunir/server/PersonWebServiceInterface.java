package me.yunir.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "PersonService")
public interface PersonWebServiceInterface {

    @WebMethod(operationName = "getAllPersons")
    List<Person> getAllPersons();

    @WebMethod(operationName = "getPersonsByName")
    List<Person> getPersonsByName(@WebParam(name = "personName") String name);
}