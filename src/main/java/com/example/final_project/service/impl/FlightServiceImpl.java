package com.example.final_project.service.impl;

import com.example.final_project.dto.FlightDto;
import com.example.final_project.entity.Flight;
import com.example.final_project.mapper.FlightMapper;
import com.example.final_project.repository.FlightRepository;
import com.example.final_project.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    public List<FlightDto> getAll() {
        return flightMapper.toDtoList(flightRepository.findAll());
    }

    @Override
    public FlightDto getById(Long id) {
        return flightMapper.toDto(flightRepository.findById(id).orElse(null));
    }

    @Override
    public FlightDto addFlight(FlightDto flightDto) {
        return flightMapper.toDto(flightRepository.save(flightMapper.toEntity(flightDto)));
    }

    @Override
    public FlightDto updateById(Long id, FlightDto flightDto) {
        Flight flight = flightMapper.toEntity(flightDto);
        Flight updateFlight = flightRepository.findById(id).orElse(null);

        if (updateFlight != null) {
            updateFlight.setFlightNumber(flight.getFlightNumber());
            updateFlight.setStatus(flight.getStatus());
            updateFlight.setDepartureAirportCode(flight.getDepartureAirportCode());
            updateFlight.setArrivalAirportCode(flight.getArrivalAirportCode());
            updateFlight.setAirline(flight.getAirline());
            updateFlight.setAirports(flight.getAirports());

            return flightMapper.toDto(flightRepository.save(updateFlight));
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        flightRepository.deleteById(id);
        return flightRepository.findById(id).isEmpty();
    }
}