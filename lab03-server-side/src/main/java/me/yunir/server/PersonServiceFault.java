package me.yunir.server;

public class PersonServiceFault {
    private static final String DEFAULT_MESSAGE = "argument cannot be null or empty";
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static PersonServiceFault defaultInstance() {
        PersonServiceFault fault = new PersonServiceFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}