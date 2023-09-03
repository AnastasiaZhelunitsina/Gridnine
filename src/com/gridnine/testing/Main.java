package com.gridnine.testing;

import com.gridnine.testing.filters.Impl.DepartureBeforeCurrentTime;
import com.gridnine.testing.filters.Impl.LandingBeforeDeparture;
import com.gridnine.testing.filters.Impl.TotalTimeOnGroundExceedTwoHours;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.util.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> departureBeforeCurrentTime = new DepartureBeforeCurrentTime().filter(flights);
        List<Flight> landingBeforeDeparture = new LandingBeforeDeparture().filter(flights);
        List<Flight> totalTimeOnGroundExceedTwoHours = new TotalTimeOnGroundExceedTwoHours().filter(flights);


        System.out.println("List of all flights:");
        System.out.println(flights + "\n");

        System.out.println("Departure before current time:");
        System.out.println(departureBeforeCurrentTime + "\n");

        System.out.println("Landing before departure:");
        System.out.println(landingBeforeDeparture + "\n");

        System.out.println("Total time spent on the ground exceeds 2 hours:");
        System.out.println(totalTimeOnGroundExceedTwoHours + "\n");
    }
}
