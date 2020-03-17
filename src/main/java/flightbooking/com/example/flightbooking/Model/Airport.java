package flightbooking.com.example.flightbooking.Model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    private String airportName;
    @Column
    private String airportShortName;
    @Column
    private String airportLocation;






}
