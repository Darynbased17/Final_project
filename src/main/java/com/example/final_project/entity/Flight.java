package com.example.final_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;

    private String status;

    private String departureAirportCode;

    private String arrivalAirportCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Airport> airports;
}
