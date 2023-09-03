package com.gridnine.testing.filters.Impl;

import com.gridnine.testing.filters.Filters;
import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class LandingBeforeDeparture implements Filters {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
