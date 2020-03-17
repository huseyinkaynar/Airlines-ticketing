package flightbooking.com.example.flightbooking.Repositories;

import flightbooking.com.example.flightbooking.Model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepo extends JpaRepository<Route,Long> {
}
