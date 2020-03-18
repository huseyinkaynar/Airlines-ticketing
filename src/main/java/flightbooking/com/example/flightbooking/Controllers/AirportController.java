package flightbooking.com.example.flightbooking.Controllers;


import flightbooking.com.example.flightbooking.Model.Airport;
import flightbooking.com.example.flightbooking.Services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "airport")
public class AirportController {
    @Autowired
    AirportService airportService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Airport>> getAllAirport() {
        return new ResponseEntity<>(airportService.allAirport(), HttpStatus.OK);
    }

    @PostMapping("")
    public String postAirport(@RequestBody Airport airport) {
        airportService.saveAirport(airport);
        return "saved";
    }
    @GetMapping("/search")
    @ResponseBody
    public ResponseEntity<List<Airport>> searchAirport(@RequestParam(value = "airport_name") String airport) {
        return new ResponseEntity<>(airportService.getSearchAirport(airport), HttpStatus.OK);
    }

}
