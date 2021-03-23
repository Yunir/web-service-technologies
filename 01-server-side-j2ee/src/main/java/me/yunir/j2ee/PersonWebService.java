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
    @Resource(lookup = "jdbc/ifmo-ws")
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
}