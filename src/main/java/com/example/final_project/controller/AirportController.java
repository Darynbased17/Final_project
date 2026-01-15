package com.example.final_project.controller;

import com.example.final_project.dto.AirportDto;
import com.example.final_project.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;

    @GetMapping
    public List<AirportDto> getAll() {
        return airportService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportDto> getById(@PathVariable("id") Long id) {
        AirportDto airportDto = airportService.getById(id);
        if (airportDto != null) {
            return ResponseEntity.ok(airportDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AirportDto> addAirport(@RequestBody AirportDto airportDto) {
        return ResponseEntity.ok(airportService.addAirport(airportDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportDto> updateById(@PathVariable("id") Long id, @RequestBody AirportDto airportDto) {
        AirportDto updatedAirportDto = airportService.updateById(id, airportDto);
        if (updatedAirportDto != null) {
            return ResponseEntity.ok(updatedAirportDto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        boolean isDeleted = airportService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}