package me.yunir.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import me.yunir.server.Person;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class App {

    private static final String URL = "http://localhost:8080/rest/persons";

    public static void main(String[] args) {
        Client client = Client.create();
        printList(getAllPersons(client, null));
        System.out.println();
        printList(getAllPersons(client, "Владимир"));
        long personId = addPerson(
                "John",
                "Johnson",
                "Jhon.Jhonson@gmail.com",
                "+71112223344",
                63);
        System.out.println("Added person id: " + personId);
        int opCode = changePerson(
                personId,
                "Mary",
                "Fedorovna",
                "Mary.Fedorovna@gmail.com",
                "+71112223344",
                63);
        System.out.println("Updated person id: " + personId + "; Operation code: " + opCode);
        opCode = removePerson(personId);
        System.out.println("Removed person id: " + personId + "; Operation code: " + opCode);
    }

    private static int removePerson(long id) {
        // TODO: implement REST-call
        return 0;
    }

    private static int changePerson(long id, String name, String surname, String email, String number, int age) {
        // TODO: implement REST-call
        return 0;
    }

    private static long addPerson(String name, String surname, String email, String number, int age) {
        // TODO: implement REST-call
        return 0;
    }


    private static List<Person> getAllPersons(Client client, String name) {
        WebResource webResource = client.resource(URL);
        if (name != null) {
            webResource = webResource.queryParam("name", name);
        }
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<Person>> type = new GenericType<List<Person>>() {
        };
        return response.getEntity(type);
    }

    private static void printList(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
