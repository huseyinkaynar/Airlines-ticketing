package flightbooking.com.example.flightbooking.Services;

import flightbooking.com.example.flightbooking.Model.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportService {

    void saveAirport(Airport airport);
    List<Airport> allAirport();
    Optional<Airport> findById(Long id);

}
