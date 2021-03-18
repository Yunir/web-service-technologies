package me.yunir;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;

/**
 * Веб-сервис.
 * Содержит операции веб-сервиса.
 * Содержит инъекцию источника данных, настроенного на стороне сервера приложений.
 */
@WebService(serviceName = "PersonService")
public class PersonWebService {
    @Resource(lookup = "jdbc/ifmo-ws")
    private DataSource dataSource;

    @WebMethod(operationName = "getAllPersons")
    public List<Person> getAllPersons() {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersons();
    }

    /*@WebMethod(operationName = "getPersonsByName")
    public List<Person> getPersonsByName(@WebParam(name = "personName") String name) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersonsByName(name);
    }*/

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}