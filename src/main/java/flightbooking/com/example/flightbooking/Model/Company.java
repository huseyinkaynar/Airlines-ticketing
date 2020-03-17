package flightbooking.com.example.flightbooking.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    private String companyName;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private Set<Flight> flights;


}
