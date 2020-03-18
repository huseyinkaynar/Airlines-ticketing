package flightbooking.com.example.flightbooking.Services;

import flightbooking.com.example.flightbooking.Model.Ticket;

import java.util.List;

public interface TicketService {

    void saveTicket(Ticket ticket);
    List<Ticket> allTicket();
    void deleteTicket(Long id);
}
