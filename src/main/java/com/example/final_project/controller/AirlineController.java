package com.example.final_project.controller;

import com.example.final_project.dto.AirlineDto;
import com.example.final_project.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/airlines")
public class AirlineController {

    private final AirlineService airlineService;

    @GetMapping
    public List<AirlineDto> getAll() {
        return airlineService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirlineDto> getById(@PathVariable("id") Long id) {
        AirlineDto airlineDto = airlineService.getById(id);
        return airlineDto != null ? ResponseEntity.ok(airlineDto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AirlineDto> addAirline(@RequestBody AirlineDto airlineDto) {
        return ResponseEntity.ok(airlineService.addAirline(airlineDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirlineDto> updateById(@PathVariable("id") Long id, @RequestBody AirlineDto airlineDto) {
        AirlineDto updatedAirlineDto = airlineService.updateById(id, airlineDto);
        return updatedAirlineDto != null ? ResponseEntity.ok(updatedAirlineDto) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AirlineDto> deleteById(@PathVariable("id") Long id) {
        boolean isDeleted = airlineService.deleteById(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}