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
            persons = processPersonsResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }

    public List<Person> getPersonsByName(String customName) {
        List<Person> persons = new ArrayList<>();
        try (Statement stmt = dbConnection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from customers where name='" + customName + "'");
            persons = processPersonsResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }

    public List<Person> getPersonsBySurname(String customSurname) {
        List<Person> persons = new ArrayList<>();
        try (Statement stmt = dbConnection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from customers where surname='" + customSurname + "'");
            persons = processPersonsResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }

    public List<Person> getPersonsByEmail(String customEmail) {
        List<Person> persons = new ArrayList<>();
        try (Statement stmt = dbConnection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from customers where email='" + customEmail + "'");
            persons = processPersonsResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }

    public List<Person> getPersonsByPhone(String customPhone) {
        List<Person> persons = new ArrayList<>();
        try (Statement stmt = dbConnection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from customers where phone='" + customPhone + "'");
            persons = processPersonsResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }

    public List<Person> getPersonsByAge(String customAge) {
        List<Person> persons = new ArrayList<>();
        try (Statement stmt = dbConnection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from customers where age='" + customAge + "'");
            persons = processPersonsResultSet(rs);
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }

    private List<Person> processPersonsResultSet(ResultSet rs) throws SQLException {
        List<Person> persons = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            int age = rs.getInt("age");
            Person person = new Person(name, surname, email, phone, age);
            persons.add(person);
        }
        return persons;
    }
}