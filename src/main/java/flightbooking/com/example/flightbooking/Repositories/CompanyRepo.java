package flightbooking.com.example.flightbooking.Repositories;

import flightbooking.com.example.flightbooking.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Long> {
}
