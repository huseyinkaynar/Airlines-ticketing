package flightbooking.com.example.flightbooking.Services.Imp;

import flightbooking.com.example.flightbooking.Model.Airport;
import flightbooking.com.example.flightbooking.Repositories.AirportRepo;
import flightbooking.com.example.flightbooking.Services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImp implements AirportService {
    @Autowired
    AirportRepo airportRepo;


    @Override
    public void saveAirport(Airport airport) {
        airportRepo.save(airport);


    }

    @Override
    public List<Airport> allAirport() {
        return airportRepo.findAll();
    }

    @Override
    public Optional<Airport> findById(Long id){
        return airportRepo.findById(id);


    }


}
