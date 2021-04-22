package me.yunir.j2ee;

import me.yunir.shared.Person;
import me.yunir.shared.PersonWebServiceInterface;
import me.yunir.shared.PostgreSQLDAO;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.util.List;

import static me.yunir.j2ee.ConnectionUtil.getConnection;

/**
 * Веб-сервис.
 * Содержит операции веб-сервиса.
 * Содержит инъекцию источника данных, настроенного на стороне сервера приложений.
 */
@WebService(serviceName = "PersonService")
public class PersonWebService implements PersonWebServiceInterface {
    @Resource(lookup = "jdbc/shop")
    private DataSource dataSource;

    @Override
    @WebMethod(operationName = "getAllPersons")
    public List<Person> getAllPersons() {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection(dataSource));
        return dao.getPersons();
    }

    @Override
    @WebMethod(operationName = "getPersonsByName")
    public List<Person> getPersonsByName(@WebParam(name = "personName") String name) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection(dataSource));
        return dao.getPersonsByName(name);
    }

    @WebMethod(operationName = "getPersonsBySurname")
    public List<Person> getPersonsBySurname(@WebParam(name = "personSurname") String surname) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection(dataSource));
        return dao.getPersonsBySurname(surname);
    }

    @WebMethod(operationName = "getPersonsByEmail")
    public List<Person> getPersonsByEmail(@WebParam(name = "personEmail") String email) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection(dataSource));
        return dao.getPersonsByEmail(email);
    }

    @WebMethod(operationName = "getPersonsByPhone")
    public List<Person> getPersonsByPhone(@WebParam(name = "personPhone") String phone) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection(dataSource));
        return dao.getPersonsByPhone(phone);
    }

    @WebMethod(operationName = "getPersonsByAge")
    public List<Person> getPersonsByAge(@WebParam(name = "personAge") String age) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection(dataSource));
        return dao.getPersonsByAge(age);
    }
}