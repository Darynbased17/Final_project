package com.example.final_project.Repository;

import com.example.final_project.Entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository <Airport, Long> {
}
