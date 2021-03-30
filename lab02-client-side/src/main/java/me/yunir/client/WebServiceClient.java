package me.yunir.client;

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


    }
}
