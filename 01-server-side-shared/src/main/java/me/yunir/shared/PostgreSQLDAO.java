package me.yunir.shared;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Data Access Object
 */
public class PostgreSQLDAO {
    Connection dbConnection;

    public PostgreSQLDAO(Connection connection) {
        this.dbConnection = connection;
    }

    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        try (Statement stmt = dbConnection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from customers");
            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int age = rs.getInt("age");
                Person person = new Person(name, surname, email, phone, age);
                persons.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }

    public List<Person> getPersonsByName(String name) {
        //TODO: implement it
        return null;
    }
}