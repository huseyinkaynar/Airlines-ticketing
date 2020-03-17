package flightbooking.com.example.flightbooking.Controllers;


import flightbooking.com.example.flightbooking.Model.Flight;
import flightbooking.com.example.flightbooking.Services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "flight")
public class FlightController {

    @Autowired
    FlightService flightService;
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Flight>> listAllFlight(){
        return new ResponseEntity<>(flightService.allFlight(), HttpStatus.OK);

    }
    @PostMapping("")
    public String postFlight(@RequestBody Flight flight){
        flightService.saveFlight(flight);
        return "saved";
    }

}
