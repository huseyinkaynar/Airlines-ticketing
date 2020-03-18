package flightbooking.com.example.flightbooking.Repositories;

import flightbooking.com.example.flightbooking.Model.Airport;
import flightbooking.com.example.flightbooking.Model.Company;
import flightbooking.com.example.flightbooking.SearchQuery.SearchQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepo extends JpaRepository<Company,Long> {

    @Query(value = SearchQueries.Queries.companySearch, nativeQuery = true)
    List<Company> findAirportByQuery(String company_name);
}
