package com.interview.questions;

import java.util.HashMap;
import java.util.Map;

public class TaxiTicketApp {

    public static void main(String[] args) {
        TicketSystem ticketSystem = new TicketSystem();
        FareCalculator fareCalculator = new FareCalculator(750, 5);

        String source = "PUNE";
        String destination = "NASIK";

        Route route = ticketSystem.getRoute(source, destination);
        if (route == null) {
            System.out.println("Invalid source or destination");
            return;
        }

        int travelers = 2;
        Ticket ticket = new Ticket(route, travelers, fareCalculator);
        ticket.calculateTotalFare();
        ticket.printTicket();
    }
}

class TicketSystem {

    private final Map<String, Route> routes;

    TicketSystem() {
        routes = new HashMap<>();
        routes.put("PUNE_MUMBAI", new Route("PUNE", "MUMBAI", 120));
        routes.put("PUNE_NASIK", new Route("PUNE", "NASIK", 200));
        routes.put("MUMBAI_GOA", new Route("MUMBAI", "GOA", 350));
        routes.put("MUMBAI_NASIK", new Route("MUMBAI", "NASIK", 180));
    }

    public Route getRoute(String source, String destination) {
        return routes.get(source + "_" + destination);
    }
}

class FareCalculator {

    int baseFare;
    int perKmFare;

    FareCalculator(int baseFare, int perKmFare) {
        this.baseFare = baseFare;
        this.perKmFare = perKmFare;
    }

    public int calculateFare(int distance) {
        return (baseFare + (perKmFare * Math.max(0, distance - 100)));
    }
}

class Ticket {

    Route route;
    int travelers;
    FareCalculator fareCalculator;

    public Ticket(Route route, int travelers, FareCalculator fareCalculator) {
        this.route = route;
        this.travelers = travelers;
        this.fareCalculator = fareCalculator;
    }

    public int calculateTotalFare() {
        return fareCalculator.calculateFare(this.route.distance) * travelers;
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
}

class Route {

    String from;
    String to;
    int distance;

    public Route(String src, String dest, int km) {
        this.from = src;
        this.to = dest;
        this.distance = km;
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
