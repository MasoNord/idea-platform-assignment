package org.masonord;

import org.masonord.calculation.Calculation;
import org.masonord.calculation.FileCalculation;
import org.masonord.exception.FlightTicketsNotFoundException;
import org.masonord.exception.TicketsNotFoundException;
import org.masonord.model.Tickets;
import org.masonord.util.FileUtil;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    private static Calculation calculation = new FileCalculation();

    public static void main(String[] args) throws IOException, ParseException, TicketsNotFoundException, FlightTicketsNotFoundException {
        Tickets tickets = FileUtil.readFromTicketFile();

        calculation.minFlightTime(tickets,"Владивосток" , "Тель-Авив");
        calculation.diffBetweenAvePriceAndMediana(tickets, "Владивосток" , "Тель-Авив");
    }
}