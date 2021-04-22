package me.yunir.standalone;

import me.yunir.shared.Person;
import me.yunir.shared.PostgreSQLDAO;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static me.yunir.standalone.ConnectionUtil.getConnection;

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
}