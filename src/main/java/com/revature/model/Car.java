package com.revature.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String make;
    @Column
    private String model;
    @Column
    private int year;
    @ManyToOne(fetch=FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "dealership_fk")
    private Dealership dealership;

}
