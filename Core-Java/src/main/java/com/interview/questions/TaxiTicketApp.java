package com.interview.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaxiTicketApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source: ");
        String source = scanner.nextLine().toUpperCase();

        System.out.print("Enter destination: ");
        String destination = scanner.nextLine().toUpperCase();

        System.out.print("Enter number of travelers: ");
        int travelers = scanner.nextInt();

        TicketFactory ticketFactory = new TicketFactory();
        Ticket ticket = ticketFactory.createTicket(source, destination, travelers);
        if (ticket == null) {
            System.out.println("Invalid source or destination");
        } else {
            ticket.printTicket();
        }
    }
}

class Route {

    String from;
    String to;
    int distance;

    Route(String from, String to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getDistance() {
        return distance;
    }
}

interface FareCalculator {

    int calculatorFare(int distance);
}

class FareCalculatorImpl implements FareCalculator {

    int beseFase;
    int perKmFare;

    FareCalculatorImpl(int beseFase, int perKmFare) {
        this.beseFase = beseFase;
        this.perKmFare = perKmFare;
    }

    @Override
    public int calculatorFare(int distance) {
        return (beseFase + (perKmFare * Math.max(0, distance - 100)));
    }
}

class Ticket {

    Route route;
    int travelers;
    FareCalculator fareCalculator;

    Ticket(Route route, int travelers, FareCalculator fareCalculator) {
        this.route = route;
        this.fareCalculator = fareCalculator;
        this.travelers = travelers;
    }

    public void printTicket() {
        System.out.println("Taxi Ticket");
        System.out.println("-----------");
        System.out.println("Source: " + route.getFrom());
        System.out.println("Destination: " + route.getTo());
        System.out.println("Kms: " + route.getDistance());
        System.out.println("No. of travellers = " + travelers);
        System.out.println("Total = " + calculateTotalFare() + " INR");
    }

    private int calculateTotalFare() {
        return fareCalculator.calculatorFare(this.route.distance) * travelers;
    }

}

class TicketFactory {

    private final Map<String, Route> routes;

    TicketFactory() {
        this.routes = new HashMap<>();
        routes.put("PUNE_MUMBAI", new Route("PUNE", "MUMBAI", 120));
        routes.put("PUNE_NASIK", new Route("PUNE", "NASIK", 200));
        routes.put("MUMBAI_GOA", new Route("MUMBAI", "GOA", 350));
        routes.put("MUMBAI_NASIK", new Route("MUMBAI", "NASIK", 180));
    }

    public Ticket createTicket(String source, String destination, int travelers) {
        Route route = routes.get(source + "_" + destination);
        if (route == null) {
            return null;
        }
        FareCalculator calculator = new FareCalculatorImpl(750, 5);
        return new Ticket(route, travelers, calculator);
    }
}
