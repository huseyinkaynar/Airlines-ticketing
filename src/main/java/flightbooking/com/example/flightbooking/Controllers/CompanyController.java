package flightbooking.com.example.flightbooking.Controllers;

import flightbooking.com.example.flightbooking.Model.Company;
import flightbooking.com.example.flightbooking.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Company>> getAllCompany(){
        return new ResponseEntity<>(companyService.allCompany(), HttpStatus.OK) ;
    }
    @PostMapping("")
    public String postCompany(@RequestBody Company company){
        companyService.saveCompany(company);
        return "saved";
    }
}
