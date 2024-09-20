package ao.com.costs.costswebapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="service")
public class Service {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="projectID")
    private Long projectID;

    @Column(name="name")
    private String name;

    @Column(name="budget")
    private float budget;

    @Column(name="description")
    private String description;

    @Column(name="numberOfServices")
    private Long numberOfServices;

}