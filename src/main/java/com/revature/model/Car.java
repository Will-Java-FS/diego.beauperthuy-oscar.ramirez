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
    @Column(name = "car_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String make;
    @Column
    private String model;
    @Column
    private int year;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dealership_id")
    @JsonBackReference
    private Dealership dealership;

}