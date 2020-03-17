package flightbooking.com.example.flightbooking.Services.Imp;

import flightbooking.com.example.flightbooking.Model.Company;
import flightbooking.com.example.flightbooking.Repositories.CompanyRepo;
import flightbooking.com.example.flightbooking.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CompanyServiceImp implements CompanyService {
    @Autowired
    CompanyRepo companyRepo;

    @Override
    public void saveCompany(Company company) {
        companyRepo.save(company);

    }

    @Override
    public List<Company> allCompany() {
        return companyRepo.findAll();
    }
}

