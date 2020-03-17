package flightbooking.com.example.flightbooking.Repositories;

import flightbooking.com.example.flightbooking.Model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport,Long> {
}
