package me.yunir.server;

import me.yunir.shared.Person;
import me.yunir.shared.PersonWebServiceInterface;
import me.yunir.shared.PostgreSQLDAO;

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
    public int addPerson(
            @WebParam(name = "personName") String name,
            @WebParam(name = "personSurname") String surname,
            @WebParam(name = "personEmail") String email,
            @WebParam(name = "personPhone") String phone,
            @WebParam(name = "personAge") int age
    ) {

        return -1;
    }

    @WebMethod(operationName = "changePerson")
    public int changePerson(
            @WebParam(name = "personId") int id,
            @WebParam(name = "personName") String name,
            @WebParam(name = "personSurname") String surname,
            @WebParam(name = "personEmail") String email,
            @WebParam(name = "personPhone") String phone,
            @WebParam(name = "personAge") int age
    ) {

        return -1;
    }

    @WebMethod(operationName = "getAllPersons")
    public List<Person> getAllPersons() {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersons();
    }

    @WebMethod(operationName = "getPersonsByName")
    public List<Person> getPersonsByName(@WebParam(name = "personName") String name) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersonsByName(name);
    }

    @WebMethod(operationName = "getPersonsBySurname")
    public List<Person> getPersonsBySurname(@WebParam(name = "personSurname") String surname) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersonsBySurname(surname);
    }

    @WebMethod(operationName = "getPersonsByEmail")
    public List<Person> getPersonsByEmail(@WebParam(name = "personEmail") String email) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersonsByEmail(email);
    }

    @WebMethod(operationName = "getPersonsByPhone")
    public List<Person> getPersonsByPhone(@WebParam(name = "personPhone") String phone) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersonsByPhone(phone);
    }

    @WebMethod(operationName = "getPersonsByAge")
    public List<Person> getPersonsByAge(@WebParam(name = "personAge") String age) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersonsByAge(age);
    }
}