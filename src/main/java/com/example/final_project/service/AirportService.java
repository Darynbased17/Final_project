package com.example.final_project.service;

import com.example.final_project.dto.AirportDto;
import java.util.List;

public interface AirportService {
    List<AirportDto> getAll();
    AirportDto getById(Long id);
    AirportDto addAirport(AirportDto airportDto);
    AirportDto updateById(Long id, AirportDto airportDto);
    boolean deleteById(Long id);
}