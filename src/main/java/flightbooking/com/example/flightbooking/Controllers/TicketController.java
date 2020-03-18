package flightbooking.com.example.flightbooking.Controllers;

import flightbooking.com.example.flightbooking.Model.Route;
import flightbooking.com.example.flightbooking.Model.Ticket;
import flightbooking.com.example.flightbooking.Services.RouteService;
import flightbooking.com.example.flightbooking.Services.TicketSellService;
import flightbooking.com.example.flightbooking.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;
    @Autowired
    TicketSellService ticketSellService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Ticket>> listRoute(){
        return new ResponseEntity<>(ticketService.allTicket(), HttpStatus.OK);
    }
    @PostMapping("")
    public String postRoute(@RequestBody Ticket ticket){
        ticketService.saveTicket(ticket);
        return "saved";
    }
    @DeleteMapping("/{id}")
    public  void delete(@PathVariable Long id){
        ticketService.deleteTicket(id);
    }
    @PostMapping(value = "/sell")
    public ResponseEntity<String> purchase(@RequestBody Ticket ticket) {
        ticketSellService.sellTicket(ticket);
        return new ResponseEntity<>("ticket sell", HttpStatus.OK);
    }
    @PutMapping("/cancelticket/{id}")
    public ResponseEntity<String> cancel(@PathVariable  Long id,@RequestBody Ticket ticket){
        ticketSellService.cancelTicket(id,ticket);
        return new ResponseEntity<>("ticket gone", HttpStatus.OK);
    }

}
