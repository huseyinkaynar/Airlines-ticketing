package flightbooking.com.example.flightbooking.Repositories;

import flightbooking.com.example.flightbooking.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket,Long> {
}
