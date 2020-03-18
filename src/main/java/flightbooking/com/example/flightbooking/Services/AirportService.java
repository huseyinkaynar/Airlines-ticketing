package flightbooking.com.example.flightbooking.Services;

import flightbooking.com.example.flightbooking.Model.Airport;

import java.util.List;

public interface AirportService {

    void saveAirport(Airport airport);
    List<Airport> allAirport();


}
