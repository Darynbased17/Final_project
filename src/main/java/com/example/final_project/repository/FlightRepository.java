package com.example.final_project.repository;

import com.example.final_project.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}
