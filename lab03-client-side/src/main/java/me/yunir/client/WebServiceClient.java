package me.yunir.client;

import com.sun.xml.internal.ws.fault.ServerSOAPFaultException;
import me.yunir.server.IllegalArgumentException;
import me.yunir.server.IllegalSQLOperationException;
import me.yunir.server.Person;
import me.yunir.server.PersonService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/PersonService?wsdl");
        PersonService personService = new PersonService(url);
        List<Person> persons = personService.getPersonWebServicePort().getAllPersons();
        for (Person person : persons) {
            System.out.println("name: " + person.getName() +
                    ", surname: " + person.getSurname() +
                    ", email: " + person.getEmail() +
                    ", phone: " + person.getPhone() +
                    ", age: " + person.getAge());
        }
        System.out.println("Total persons: " + persons.size());
        try {
            long personId = personService.getPersonWebServicePort().addPerson(
                    "John",
                    "Johnson",
                    "Jhon.Jhonson@gmail.com",
                    "+71112223344",
                    63);
            System.out.println("Added person id: " + personId);
            int opCode = personService.getPersonWebServicePort().changePerson(
                    personId,
                    "Mary",
                    "Fedorovna",
                    "Mary.Fedorovna@gmail.com",
                    "+71112223344",
                    63);
            System.out.println("Updated person id: " + personId + "; Operation code: " + opCode);
            opCode = personService.getPersonWebServicePort().removePerson(personId);
            System.out.println("Removed person id: " + personId + "; Operation code: " + opCode);
        } catch (IllegalSQLOperationException | IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            personService.getPersonWebServicePort().getPersonsByEmail("");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            personService.getPersonWebServicePort().addPerson(
                    "John",
                    "Johnson",
                    "Jhon.Jhonson@gmail.com",
                    "+71112223344",
                    -9999);
        } catch (IllegalArgumentException | IllegalSQLOperationException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            personService.getPersonWebServicePort().removePerson(999);
        } catch (IllegalSQLOperationException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
