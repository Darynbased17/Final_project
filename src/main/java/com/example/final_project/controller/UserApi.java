package com.example.final_project.controller;

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
    public ResponseEntity<?> addAirline(@RequestBody Object airlineDto) {
        return ResponseEntity.ok("Airline added (admin only)");
    }

    @PostMapping("/airport/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> addAirport(@RequestBody Object airportDto) {
        return ResponseEntity.ok("Airport added (admin only)");
    }

    @PostMapping("/flight/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> addFlight(@RequestBody Object flightDto) {
        return ResponseEntity.ok("Flight added (admin only)");
    }

    @PutMapping("/airline/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> updateAirline(@PathVariable("id") Long id, @RequestBody Object airlineDto) {
        return ResponseEntity.ok("Airline updated (admin only)");
    }

    @PutMapping("/airport/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> updateAirport(@PathVariable("id") Long id, @RequestBody Object airportDto) {
        return ResponseEntity.ok("Airport updated (admin only)");
    }

    @PutMapping("/flight/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> updateFlight(@PathVariable("id") Long id, @RequestBody Object flightDto) {
        return ResponseEntity.ok("Flight updated (admin only)");
    }

    @DeleteMapping("/airline/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> deleteAirline(@PathVariable("id") Long id) {
        return ResponseEntity.ok("Airline deleted (admin only)");
    }

    @DeleteMapping("/airport/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> deleteAirport(@PathVariable("id") Long id) {
        return ResponseEntity.ok("Airport deleted (admin only)");
    }

    @DeleteMapping("/flight/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> deleteFlight(@PathVariable("id") Long id) {
        return ResponseEntity.ok("Flight deleted (admin only)");
    }
}