package com.example.final_project.service;

import com.example.final_project.dto.AirlineDto;
import java.util.List;

public interface AirlineService {
    List<AirlineDto> getAll();
    AirlineDto getById(Long id);
    AirlineDto addAirline(AirlineDto airlineDto);
    AirlineDto updateById(Long id, AirlineDto airlineDto);
    boolean deleteById(Long id);
}