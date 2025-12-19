package com.example.final_project.controller;

import com.example.final_project.dto.FlightDto;
import com.example.final_project.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public List<FlightDto> getAll() {
        return flightService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getById(@PathVariable("id") Long id) {
        FlightDto flightDto = flightService.getById(id);
        return flightDto != null ? ResponseEntity.ok(flightDto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FlightDto> addFlight(@RequestBody FlightDto flightDto) {
        return ResponseEntity.ok(flightService.addFlight(flightDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightDto> updateById(@PathVariable("id") Long id, @RequestBody FlightDto flightDto) {
        FlightDto updatedFlightDto = flightService.updateById(id, flightDto);
        return updatedFlightDto != null ? ResponseEntity.ok(updatedFlightDto) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FlightDto> deleteById(@PathVariable("id") Long id) {
        boolean isDeleted = flightService.deleteById(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}