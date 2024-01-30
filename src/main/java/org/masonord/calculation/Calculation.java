package org.masonord.calculation;

import org.masonord.exception.FlightTicketsNotFoundException;
import org.masonord.exception.TicketsNotFoundException;
import org.masonord.model.Tickets;

import java.io.IOException;
import java.text.ParseException;

public interface Calculation {
    void minFlightTime(Tickets tickets, String originName, String destinationName) throws ParseException, IOException, FlightTicketsNotFoundException, TicketsNotFoundException;

    void diffBetweenAvePriceAndMediana(Tickets tickets, String originName, String destinationName) throws IOException, FlightTicketsNotFoundException, TicketsNotFoundException;
}
