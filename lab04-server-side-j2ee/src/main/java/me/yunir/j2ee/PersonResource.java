package me.yunir.j2ee;

import me.yunir.shared.Person;
import me.yunir.shared.PostgreSQLDAO;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static me.yunir.j2ee.ConnectionUtil.getConnection;

@Path("/persons")
@Produces({MediaType.APPLICATION_JSON})
public class PersonResource {
    @Resource(lookup = "jdbc/shop")
    private DataSource dataSource;

    @GET
    public List<Person> getPersons(@QueryParam("name") String name,
                                   @QueryParam("surname") String surname,
                                   @QueryParam("email") String email,
                                   @QueryParam("phone") String phone,
                                   @QueryParam("age") String age) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection(dataSource));
        return dao.getPersonsCustom(name, surname, email, phone, age);
    }
}