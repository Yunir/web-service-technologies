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
        persons = personService.getPersonWebServicePort().getPersonsByEmail("Марк@яндекс.ру");
        for (Person person : persons) {
            System.out.println("name: " + person.getName() +
                    ", surname: " + person.getSurname() +
                    ", email: " + person.getEmail() +
                    ", phone: " + person.getPhone() +
                    ", age: " + person.getAge());
        }
        System.out.println("Total persons: " + persons.size());
        persons = personService.getPersonWebServicePort().getPersonsByAge("29");
        for (Person person : persons) {
            System.out.println("name: " + person.getName() +
                    ", surname: " + person.getSurname() +
                    ", email: " + person.getEmail() +
                    ", phone: " + person.getPhone() +
                    ", age: " + person.getAge());
        }
        System.out.println("Total persons: " + persons.size());

    }
}
