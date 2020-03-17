package flightbooking.com.example.flightbooking.Services.Imp;

import flightbooking.com.example.flightbooking.Model.Route;
import flightbooking.com.example.flightbooking.Repositories.RouteRepo;
import flightbooking.com.example.flightbooking.Services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class RouteServiceImp implements RouteService {
    @Autowired
    RouteRepo routeRepo;


    @Override
    public void saveRoute(Route route) {
        routeRepo.save(route);

    }

    @Override
    public List<Route> allRoute() {
        return routeRepo.findAll();
    }
}
