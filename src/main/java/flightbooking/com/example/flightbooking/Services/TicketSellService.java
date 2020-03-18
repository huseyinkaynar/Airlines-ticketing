package flightbooking.com.example.flightbooking.Services;

import flightbooking.com.example.flightbooking.Model.Ticket;

public interface TicketSellService  {
    void sellTicket(Ticket ticket);
    void cancelTicket (Long id, Ticket ticket);
}
