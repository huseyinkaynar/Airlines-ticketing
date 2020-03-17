package flightbooking.com.example.flightbooking.Model;


import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "originAirport_id" ,nullable = false)
    private Airport originAirport;

    @ManyToOne
    @JoinColumn(name = "destAirport_id" ,nullable = false)
    private Airport destAirport;

    @OneToMany(mappedBy = "route")
    @JsonIgnore
    private Set<Flight> flights;


}
