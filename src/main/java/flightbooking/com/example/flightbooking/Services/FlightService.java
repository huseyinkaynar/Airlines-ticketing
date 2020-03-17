package flightbooking.com.example.flightbooking.Services;

import flightbooking.com.example.flightbooking.Model.Flight;

import java.util.List;

public interface FlightService {
    void saveFlight(Flight flight);
    List<Flight> allFlight();
}
