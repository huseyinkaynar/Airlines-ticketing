package flightbooking.com.example.flightbooking.Repositories;

import flightbooking.com.example.flightbooking.Model.Airport;

import flightbooking.com.example.flightbooking.SearchQuery.SearchQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirportRepo extends JpaRepository<Airport,Long> {


    @Query(value = SearchQueries.Queries.airportSearch, nativeQuery = true)
    List<Airport> findAirportByQuery(String airport_name);
}
