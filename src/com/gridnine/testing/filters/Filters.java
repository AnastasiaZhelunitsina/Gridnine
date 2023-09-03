package com.gridnine.testing.filters;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface Filters {

    List<Flight> filter(List<Flight> flights);
}
