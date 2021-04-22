package me.yunir.server;

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

    public List<Person> getPersonsCustom(String name, String surname, String email, String phone, String age) {
        if (name == null && surname == null && email == null && phone == null && age == null)
            return getPersons();
        List<Person> persons = new ArrayList<>();
        List<String> customs = new ArrayList<>();
        if (name != null) {
            customs.add("name='" + name + "'");
        }
        if (surname != null) {
            customs.add("surname='" + surname + "'");
        }
        if (email != null) {
            customs.add("email='" + email + "'");
        }
        if (phone != null) {
            customs.add("phone='" + phone + "'");
        }
        if (age != null) {
            customs.add("age='" + age + "'");
        }
        String customization = String.join(" AND ", customs);
        try (Statement stmt = dbConnection.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from customers where " + customization);
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
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public int changePersons(long id, String name, String surname, String email, String phone, int age) {
        String sql = "UPDATE customers SET name=?, surname=?, email=?, phone=?, age=? WHERE id=?";
        try (PreparedStatement stmt = dbConnection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setInt(5, age);
            stmt.setLong(6, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public int removePersons(long id) {
        String sql = "DELETE FROM customers WHERE id=?";
        try (PreparedStatement stmt = dbConnection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}