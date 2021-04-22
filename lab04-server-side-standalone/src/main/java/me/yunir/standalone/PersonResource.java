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
    public List<Person> getPersons(@QueryParam("name") String name) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        if (name == null)
            return dao.getPersons();
        else
            return dao.getPersonsByName(name);
    }
}