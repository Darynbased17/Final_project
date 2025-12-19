package com.example.final_project.service;

import com.example.final_project.dto.FlightDto;
import java.util.List;

public interface FlightService {
    List<FlightDto> getAll();
    FlightDto getById(Long id);
    FlightDto addFlight(FlightDto flight);
    FlightDto updateById(Long id, FlightDto flightDto);
    boolean deleteById(Long id);
}