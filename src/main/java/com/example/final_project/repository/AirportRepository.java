package com.example.final_project.repository;

import com.example.final_project.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository <Airport, Long> {
}
