package flightbooking.com.example.flightbooking.Controllers;


import flightbooking.com.example.flightbooking.Model.Route;
import flightbooking.com.example.flightbooking.Services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "route")
public class RouteController {
    @Autowired
    RouteService routeService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Route>> listRoute(){
        return new ResponseEntity<>(routeService.allRoute(), HttpStatus.OK);
    }
    @PostMapping("")
    public String postRoute(@RequestBody Route route){
        routeService.saveRoute(route);
        return "saved";
    }
}
