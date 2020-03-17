package flightbooking.com.example.flightbooking.Services;

import flightbooking.com.example.flightbooking.Model.Route;

import java.util.List;

public interface RouteService {
    void saveRoute(Route route);
    List<Route> allRoute();
}
