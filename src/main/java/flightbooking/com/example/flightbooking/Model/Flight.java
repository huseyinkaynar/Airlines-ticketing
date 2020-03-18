package flightbooking.com.example.flightbooking.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(mappedBy = "flight")
    private Set<Ticket> tickets;
    @Column
    private String startPrice;




    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column
    private Date date;
    @Column
    private Long numberOfTicket;
    @Column
    private Long soldTicket;


}
