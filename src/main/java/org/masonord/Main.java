package org.masonord;

import org.masonord.calculation.Calculation;
import org.masonord.calculation.FileCalculation;
import org.masonord.model.Tickets;
import org.masonord.util.FileUtil;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    private static Calculation calculation = new FileCalculation();

    public static void main(String[] args) throws IOException, ParseException {
        Tickets tickets = FileUtil.readFromTicketFile(
                args.length == 0 ? "default" : args[1]
        );

        calculation.minFlightTime(tickets,"Владивосток" , "Тель-Авив");
        calculation.diffBetweenAvePriceAndMediana(tickets, "Владивосток" , "Тель-Авив");
    }
}