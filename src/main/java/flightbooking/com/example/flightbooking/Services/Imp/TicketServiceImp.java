package flightbooking.com.example.flightbooking.Services.Imp;

import flightbooking.com.example.flightbooking.Model.Ticket;
import flightbooking.com.example.flightbooking.Repositories.TicketRepo;
import flightbooking.com.example.flightbooking.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketServiceImp implements TicketService {
    @Autowired
    TicketRepo ticketRepo;

    @Override
    public void saveTicket(Ticket ticket) {
        ticketRepo.save(ticket);

    }

    @Override
    public List<Ticket> allTicket() {
        return ticketRepo.findAll();
    }

    @Override
    public void deleteTicket(Long id){
        ticketRepo.deleteById(id);
    }
}
