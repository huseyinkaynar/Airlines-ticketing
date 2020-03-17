package flightbooking.com.example.flightbooking.Services.Imp;

import flightbooking.com.example.flightbooking.Model.Flight;
import flightbooking.com.example.flightbooking.Repositories.FlightRepo;
import flightbooking.com.example.flightbooking.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class FlightServiceImp implements FlightService {
    @Autowired
    FlightRepo flightRepo;

    @Override
    public void saveFlight(Flight flight) {
        flightRepo.save(flight);

    }

    @Override
    public List<Flight> allFlight() {
        return flightRepo.findAll();
    }
}
