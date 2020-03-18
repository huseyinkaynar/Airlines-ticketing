package flightbooking.com.example.flightbooking.Services.Imp;

import flightbooking.com.example.flightbooking.Model.Flight;
import flightbooking.com.example.flightbooking.Model.Ticket;
import flightbooking.com.example.flightbooking.Repositories.FlightRepo;
import flightbooking.com.example.flightbooking.Repositories.TicketRepo;
import flightbooking.com.example.flightbooking.Services.TicketSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TicketSellServiceImp implements TicketSellService {

    @Autowired
    TicketRepo ticketRepo;
    @Autowired
    FlightRepo flightRepo;




    @Override
    public void sellTicket(Ticket ticket){
        Long id=ticket.getFlight().getId();


        Optional<Flight> sellingTicket = flightRepo.findById(id);

        Flight sellTic=sellingTicket.get();

        Long ticketLimit=sellTic.getNumberOfTicket();
        Long ticketSell=sellTic.getSoldTicket();
        Double firstPrice = Double.valueOf(sellTic.getStartPrice());

        Double rate = (double) ticketSell/ticketLimit;

        if( rate <= 0.1) {
            firstPrice = firstPrice * 1;
        }
        else if(0.1 < rate && rate <= 0.2) {
            firstPrice = firstPrice * 1.1;
        }
        else if(0.2 < rate && rate <= 0.3) {
            firstPrice = firstPrice * 1.2;
        }
        else if(0.3 < rate && rate <= 0.4) {
            firstPrice = firstPrice * 1.3;
        }
        else if(0.4 < rate && rate <= 0.5) {
            firstPrice = firstPrice * 1.4;
        }
        else if(0.5 < rate && rate <= 0.6) {
            firstPrice = firstPrice * 1.5;
        }
        else if(0.6 < rate && rate <= 0.7) {
            firstPrice = firstPrice * 1.6;
        }
        else if(0.7 < rate && rate <= 0.8) {
            firstPrice = firstPrice * 1.7;
        }
        else if(0.8 < rate && rate <= 0.9) {
            firstPrice = firstPrice * 1.8;
        }
        else if(0.9 < rate && rate < 1) {
            firstPrice = firstPrice * 1.9;
        }
        else if(rate == 1) {
            firstPrice = 0.0;
        }
        else {
            firstPrice = 0.0;
        }

        sellTic.setSoldTicket(sellTic.getSoldTicket()+1);
        flightRepo.save(sellTic);

        ticket.setPrice(firstPrice.toString());
        ticketRepo.save(ticket);

    }
    @Override
    public void cancelTicket (Long id, Ticket ticket){
        Long ticketId = ticket.getFlight().getId();

        Optional<Ticket> doneTicket = ticketRepo.findById(id);


        Ticket passTicket = doneTicket.get();


        Optional<Flight> oldTicket = flightRepo.findById(ticketId);

        Flight newTicket = oldTicket.get();

        newTicket.setSoldTicket(newTicket.getSoldTicket()-1);
        flightRepo.save(newTicket);

        ticketRepo.save(passTicket);
    }
}
