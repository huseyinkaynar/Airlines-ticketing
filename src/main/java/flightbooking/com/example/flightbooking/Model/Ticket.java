package flightbooking.com.example.flightbooking.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String price;
    @ManyToOne
    @JoinColumn(name = "flight_id",nullable = false)
    private Flight flight;






}
