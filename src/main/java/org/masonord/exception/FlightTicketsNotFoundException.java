package org.masonord.exception;

public class FlightTicketsNotFoundException extends Exception{
    public FlightTicketsNotFoundException() {}
    public FlightTicketsNotFoundException(String message) {
        super(message);
    }
}
