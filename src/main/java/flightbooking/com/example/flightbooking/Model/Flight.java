package flightbooking.com.example.flightbooking.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "flights")
public class Flight {
    public Flight(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "route_id",nullable = false)
    private Route route;


    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;


    @Column
    private Date date;


}
