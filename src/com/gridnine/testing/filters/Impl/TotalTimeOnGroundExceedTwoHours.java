package com.gridnine.testing.filters.Impl;

import com.gridnine.testing.filters.Filters;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TotalTimeOnGroundExceedTwoHours implements Filters {

    private static final long MIN_TIME_ON_GROUND = 2l;

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().size() > 1)
                .filter(flight -> moreThanTwoHours(flight.getSegments()))
                .collect(Collectors.toList());
    }

    private boolean moreThanTwoHours(List<Segment> segments) {
        long totalTime = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime landing = segments.get(i).getArrivalDate();
            LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();
            totalTime += Duration.between(landing, nextDeparture).toHours();
        }
        return totalTime > MIN_TIME_ON_GROUND;
    }
}
