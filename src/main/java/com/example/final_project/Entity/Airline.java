package com.example.final_project.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "airlines")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airline_id")
    private Long id;

    private String name;

    private String country;
}