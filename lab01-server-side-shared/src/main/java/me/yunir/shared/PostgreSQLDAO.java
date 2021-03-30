package me.yunir.shared;

import java.sql.*;
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

    public long addPersons(String name, String surname, String email, String phone, int age) {
        String sqlInsert = String.format(
                "INSERT INTO customers(name, surname, email, phone, age) values ('%s', '%s', '%s', '%s', %d);",
                name, surname, email, phone, age);
        try (PreparedStatement stmt = dbConnection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public int changePersons(int id, String name, String surname, String email, String phone, int age) {
        return 0;
    }

    public int removePersons(int id) {
        return 0;
    }
}