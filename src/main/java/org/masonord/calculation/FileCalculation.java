package org.masonord.calculation;

import org.masonord.exception.FlightTicketsNotFoundException;
import org.masonord.exception.TicketsNotFoundException;
import org.masonord.model.Ticket;
import org.masonord.model.Tickets;
import org.masonord.util.DateUtil;
import org.masonord.util.FileUtil;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class FileCalculation implements Calculation {
    @Override
    public void minFlightTime(Tickets tickets, String originName, String destinationName) throws ParseException, IOException, FlightTicketsNotFoundException, TicketsNotFoundException {
        if (!tickets.getTickets().isEmpty()) {

            HashMap<String, Double> minTime = new HashMap<>();

            for (Ticket ticket : tickets.getTickets()) {
                if (ticket.getOrigin_name().equals(originName) &&
                        ticket.getDestination_name().equals(destinationName)) {

                    double diff = DateUtil.getDateDiff(
                            DateUtil.parseStringToDate(ticket.getDeparture_date(), ticket.getDeparture_time()),
                            DateUtil.parseStringToDate(ticket.getArrival_date(), ticket.getArrival_time()),
                            TimeUnit.SECONDS
                    );

                    minTime.put(ticket.getCarrier(), Math.min(
                            minTime.getOrDefault(ticket.getCarrier(), diff), diff)
                    );
                }
            }

            if (!tickets.getTickets().isEmpty()) {
                DecimalFormat df = new DecimalFormat("#.00");
                FileUtil.writeToFile("Minimum fight time between cities " + originName +  " and " +  destinationName + ":\n");

                for (String key : minTime.keySet()) {
                    double time = minTime.get(key);

                    FileUtil.writeToFile(key + ": "
                            + time + " seconds | "
                            + time / 60 + " minutes | "
                            + df.format(time / 3600) + " hours");
                }

                return;
            }
            throw new FlightTicketsNotFoundException("The ticket list is empty for a flight from " + originName + " to " + destinationName);
        }
        throw new TicketsNotFoundException("The ticket list is empty; further execution is not possible.");
    }

    @Override
    public void diffBetweenAvePriceAndMediana(Tickets tickets, String originName, String destinationName) throws IOException, FlightTicketsNotFoundException, TicketsNotFoundException {
        if (!tickets.getTickets().isEmpty()) {
            double averagePrice = 0.0d, result = 0.0d, median = 0.0d;
            List<Integer> mainTickets = new ArrayList<>();

            for (Ticket ticket : tickets.getTickets()) {
                if (ticket.getOrigin_name().equals(originName) &&
                        ticket.getDestination_name().equals(destinationName)) {
                    averagePrice += ticket.getPrice();
                    mainTickets.add(ticket.getPrice());
                }
            }
            if (!mainTickets.isEmpty()) {
                int size = mainTickets.size() ;
                Collections.sort(mainTickets);

                averagePrice = averagePrice / size;
                median = size % 2 == 0 ?
                        (mainTickets.get((size) / 2) + mainTickets.get(size / 2 - 1)) / 2 :
                        mainTickets.get(size / 2);

                result = averagePrice - median;

                FileUtil.writeToFile("\nDifference between average price and median for a flight from " + originName + " to " + destinationName + ": " + String.valueOf(result));
                FileUtil.writeToFile("\n\t\t\t\t\t\t[Written: " + LocalTime.now() + "]\n");

                return;
            }
            throw new FlightTicketsNotFoundException("There are no tickets for a flight from " + originName + " to " + destinationName);
        }
        throw new TicketsNotFoundException("The ticket list is empty; further execution is not possible.");
    }
}
