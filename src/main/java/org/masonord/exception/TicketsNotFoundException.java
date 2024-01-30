package org.masonord.exception;

public class TicketsNotFoundException extends Exception {
    TicketsNotFoundException() {
    };

    public TicketsNotFoundException(String message) {
        super(message);
    }
}
