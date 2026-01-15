package com.example.final_project.mapper;

import com.example.final_project.dto.FlightDto;
import com.example.final_project.entity.Flight;
import java.util.List;

public interface FlightMapper {
    FlightDto toDto(Flight flight);
    Flight toEntity(FlightDto flightDto);
    List<FlightDto> toDtoList(List<Flight> flights);
}