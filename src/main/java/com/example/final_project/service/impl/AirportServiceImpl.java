package com.example.final_project.service.impl;

import com.example.final_project.dto.AirportDto;
import com.example.final_project.entity.Airport;
import com.example.final_project.mapper.AirportMapper;
import com.example.final_project.repository.AirportRepository;
import com.example.final_project.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    @Override
    public List<AirportDto> getAll() {
        return airportMapper.toDtoList(airportRepository.findAll());
    }

    @Override
    public AirportDto getById(Long id) {
        return airportMapper.toDto(airportRepository.findById(id).orElse(null));
    }

    @Override
    public AirportDto addAirport(AirportDto airportDto) {
        return airportMapper.toDto(airportRepository.save(airportMapper.toEntity(airportDto)));
    }

    @Override
    public AirportDto updateById(Long id, AirportDto airportDto) {
        Airport airport = airportMapper.toEntity(airportDto);
        Airport updateAirport = airportRepository.findById(id).orElse(null);

        updateAirport.setCode(airport.getCode());
        updateAirport.setName(airport.getName());
        updateAirport.setCity(airport.getCity());
        updateAirport.setCountry(airport.getCountry());

        return airportMapper.toDto(airportRepository.save(updateAirport));
    }

    @Override
    public boolean deleteById(Long id) {
        airportRepository.deleteById(id);
        Airport deletedAirport = airportRepository.findById(id).orElse(null);
        return deletedAirport == null;
    }
}