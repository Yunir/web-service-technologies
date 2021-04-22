package me.yunir.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static me.yunir.server.ConnectionUtil.getConnection;

@Path("/persons")
@Produces({MediaType.APPLICATION_JSON})
public class PersonResource {
    @GET
    public List<Person> getPersons(@QueryParam("name") String name,
                                   @QueryParam("surname") String surname,
                                   @QueryParam("email") String email,
                                   @QueryParam("phone") String phone,
                                   @QueryParam("age") String age) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersonsCustom(name, surname, email, phone, age);
    }

    @PUT
    public Long addPerson(
            @QueryParam("name") String name,
            @QueryParam("surname") String surname,
            @QueryParam("email") String email,
            @QueryParam("phone") String phone,
            @QueryParam("age") String age
    ) {
        if (name == null || surname == null || email == null || phone == null || age == null)
            return -1L;
        PostgreSQLDAO dao = new PostgreSQLDAO(ConnectionUtil.getConnection());
        return dao.addPersons(name, surname, email, phone, Integer.parseInt(age));
    }

    @POST
    public int changePerson(
            @QueryParam("id") long id,
            @QueryParam("name") String name,
            @QueryParam("surname") String surname,
            @QueryParam("email") String email,
            @QueryParam("phone") String phone,
            @QueryParam("age") int age
    ) {
        if (name == null || surname == null || email == null || phone == null)
            return -1;
        PostgreSQLDAO dao = new PostgreSQLDAO(ConnectionUtil.getConnection());
        return dao.changePersons(id, name, surname, email, phone, age);
    }

    @DELETE
    public int removePerson(@QueryParam("id") long id) {
        PostgreSQLDAO dao = new PostgreSQLDAO(ConnectionUtil.getConnection());
        return dao.removePersons(id);
    }
}