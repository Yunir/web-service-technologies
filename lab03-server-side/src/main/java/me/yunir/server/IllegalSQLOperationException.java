package me.yunir.server;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "me.yunir.server.errors.PersonServiceFault")
public class IllegalSQLOperationException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    private final PersonServiceFault fault;

    public IllegalSQLOperationException(String message, PersonServiceFault fault) {
        super(message);
        this.fault = fault;
    }

    public IllegalSQLOperationException(String message, PersonServiceFault fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public PersonServiceFault getFaultInfo() {
        return fault;
    }
}