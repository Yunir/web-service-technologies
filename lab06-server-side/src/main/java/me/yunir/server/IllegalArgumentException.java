package me.yunir.server;

public class IllegalArgumentException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    public static IllegalArgumentException DEFAULT_INSTANCE = new IllegalArgumentException("Arguments cannot be null or empty");

    public IllegalArgumentException(String message) {
        super(message);
    }
}