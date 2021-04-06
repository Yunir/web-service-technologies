package me.yunir.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

import static me.yunir.server.ConnectionUtil.getConnection;

/**
 * Веб-сервис.
 * Содержит операции веб-сервиса.
 * Содержит инъекцию источника данных, настроенного на стороне сервера приложений.
 */
@WebService(serviceName = "PersonService")
public class PersonWebService {

    @WebMethod(operationName = "addPerson")
    public long addPerson(
            @WebParam(name = "personName") String name,
            @WebParam(name = "personSurname") String surname,
            @WebParam(name = "personEmail") String email,
            @WebParam(name = "personPhone") String phone,
            @WebParam(name = "personAge") int age
    ) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.addPersons(name, surname, email, phone, age);
    }

    @WebMethod(operationName = "changePerson")
    public int changePerson(
            @WebParam(name = "personId") long id,
            @WebParam(name = "personName") String name,
            @WebParam(name = "personSurname") String surname,
            @WebParam(name = "personEmail") String email,
            @WebParam(name = "personPhone") String phone,
            @WebParam(name = "personAge") int age
    ) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.changePersons(id, name, surname, email, phone, age);
    }

    @WebMethod(operationName = "removePerson")
    public int removePerson(@WebParam(name = "personId") long id) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.removePersons(id);
    }

    @WebMethod(operationName = "getAllPersons")
    public List<Person> getAllPersons() {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersons();
    }

    @WebMethod(operationName = "getPersonsByName")
    public List<Person> getPersonsByName(@WebParam(name = "personName") String name) throws IllegalArgumentException {
        validateArgument(name, "personName");
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersonsByName(name);
    }

    @WebMethod(operationName = "getPersonsBySurname")
    public List<Person> getPersonsBySurname(@WebParam(name = "personSurname") String surname) throws IllegalArgumentException {
        validateArgument(surname, "personSurname");
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersonsBySurname(surname);
    }

    @WebMethod(operationName = "getPersonsByEmail")
    public List<Person> getPersonsByEmail(@WebParam(name = "personEmail") String email) throws IllegalArgumentException {
        validateArgument(email, "personEmail");
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersonsByEmail(email);
    }

    @WebMethod(operationName = "getPersonsByPhone")
    public List<Person> getPersonsByPhone(@WebParam(name = "personPhone") String phone) throws IllegalArgumentException {
        validateArgument(phone, "personPhone");
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersonsByPhone(phone);
    }

    @WebMethod(operationName = "getPersonsByAge")
    public List<Person> getPersonsByAge(@WebParam(name = "personAge") String age) throws IllegalArgumentException {
        validateArgument(age, "personAge");
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersonsByAge(age);
    }

    private void validateArgument(String argument, String argumentName) throws IllegalArgumentException {
        if (argument == null || argument.trim().isEmpty()) {
            PersonServiceFault fault = PersonServiceFault.defaultInstance();
            throw new IllegalArgumentException(argumentName + " is not specified", fault);
        }
    }
}