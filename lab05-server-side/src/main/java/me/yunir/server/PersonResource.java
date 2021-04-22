package me.yunir.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static me.yunir.server.ConnectionUtil.getConnection;

@Path("/persons")
@Produces({MediaType.APPLICATION_JSON})
public class PersonResource {
    // TODO: Implement via REST API
    /*@WebMethod(operationName = "addPerson")
    public long addPerson(
            @WebParam(name = "personName") String name,
            @WebParam(name = "personSurname") String surname,
            @WebParam(name = "personEmail") String email,
            @WebParam(name = "personPhone") String phone,
            @WebParam(name = "personAge") int age
    ) {
        PostgreSQLDAO dao = new PostgreSQLDAO(ConnectionUtil.getConnection());
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
        PostgreSQLDAO dao = new PostgreSQLDAO(ConnectionUtil.getConnection());
        return dao.changePersons(id, name, surname, email, phone, age);
    }

    @WebMethod(operationName = "removePerson")
    public int removePerson(@WebParam(name = "personId") long id) {
        PostgreSQLDAO dao = new PostgreSQLDAO(ConnectionUtil.getConnection());
        return dao.removePersons(id);
    }*/

    @GET
    public List<Person> getPersons(@QueryParam("name") String name,
                                   @QueryParam("surname") String surname,
                                   @QueryParam("email") String email,
                                   @QueryParam("phone") String phone,
                                   @QueryParam("age") String age) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersonsCustom(name, surname, email, phone, age);
    }
}