package com.example.final_project.controller;

import com.example.final_project.dto.AirlineDto;
import com.example.final_project.dto.AirportDto;
import com.example.final_project.dto.FlightDto;
import com.example.final_project.dto.UserModelDto;
import com.example.final_project.entity.UserModel;
import com.example.final_project.service.AirlineService;
import com.example.final_project.service.AirportService;
import com.example.final_project.service.FlightService;
import com.example.final_project.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserApi {

    private final MyUserService myUserService;
    private final FlightService flightService;
    private final AirlineService airlineService;
    private final AirportService airportService;

    @GetMapping
    public String getUser() {
        return "Authorized";
    }

    @PostMapping("/register")
    public UserModelDto register(@RequestBody UserModel model) {
        return myUserService.register(model);
    }

    @PostMapping("/airline/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> addAirline(@RequestBody AirlineDto airlineDto) {
        return ResponseEntity.ok(airlineService.addAirline(airlineDto));
    }

    @PostMapping("/airport/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> addAirport(@RequestBody AirportDto airportDto) {
        return ResponseEntity.ok(airportService.addAirport(airportDto));
    }

    @PostMapping("/flight/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> addFlight(@RequestBody FlightDto flightDto) {
        return ResponseEntity.ok(flightService.addFlight(flightDto));

    }
    @PutMapping("/airline/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> updateAirline(@PathVariable("id") Long id, @RequestBody AirlineDto airlineDto) {
        AirlineDto updatedAirlineDto = airlineService.updateById(id, airlineDto);
        if (updatedAirlineDto != null) {
            return ResponseEntity.ok(updatedAirlineDto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/airport/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> updateAirport(@PathVariable("id") Long id, @RequestBody AirportDto airportDto) {
        AirportDto updatedAirportDto = airportService.updateById(id, airportDto);
        if (updatedAirportDto != null) {
            return ResponseEntity.ok(updatedAirportDto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/flight/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> updateFlight(@PathVariable("id") Long id, @RequestBody FlightDto flightDto) {
        FlightDto updatedFlightDto = flightService.updateById(id, flightDto);
        if (updatedFlightDto != null) {
            return ResponseEntity.ok(updatedFlightDto);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/airline/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> deleteAirline(@PathVariable("id") Long id) {
        boolean isDeleted = airlineService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/airport/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> deleteAirport(@PathVariable("id") Long id) {
        boolean isDeleted = airportService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/flight/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> deleteFlight(@PathVariable("id") Long id) {
        boolean isDeleted = flightService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}