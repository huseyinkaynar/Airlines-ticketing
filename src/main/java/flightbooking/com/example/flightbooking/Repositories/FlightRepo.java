package flightbooking.com.example.flightbooking.Repositories;

import flightbooking.com.example.flightbooking.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository<Flight,Long> {
}
