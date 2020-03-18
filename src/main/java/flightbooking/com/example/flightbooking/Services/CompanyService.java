package flightbooking.com.example.flightbooking.Services;

import flightbooking.com.example.flightbooking.Model.Company;

import java.util.List;

public interface CompanyService {
    void saveCompany(Company company);
    List<Company> allCompany();
    List<Company> getSearchAirport(String company);
}
