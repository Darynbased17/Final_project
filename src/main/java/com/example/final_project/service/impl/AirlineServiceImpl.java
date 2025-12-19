package com.example.final_project.service.impl;

import com.example.final_project.dto.AirlineDto;
import com.example.final_project.entity.Airline;
import com.example.final_project.mapper.AirlineMapper;
import com.example.final_project.repository.AirlineRepository;
import com.example.final_project.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AirlineServiceImpl implements AirlineService {

    private final AirlineRepository airlineRepository;
    private final AirlineMapper airlineMapper;

    @Override
    public List<AirlineDto> getAll() {
        return airlineMapper.toDtoList(airlineRepository.findAll());
    }

    @Override
    public AirlineDto getById(Long id) {
        return airlineMapper.toDto(airlineRepository.findById(id).orElse(null));
    }

    @Override
    public AirlineDto addAirline(AirlineDto airlineDto) {
        return airlineMapper.toDto(airlineRepository.save(airlineMapper.toEntity(airlineDto)));
    }

    @Override
    public AirlineDto updateById(Long id, AirlineDto airlineDto) {
        Airline airline = airlineMapper.toEntity(airlineDto);
        Airline updateAirline = airlineRepository.findById(id).orElse(null);

        updateAirline.setName(airline.getName());
        updateAirline.setCountry(airline.getCountry());

        return airlineMapper.toDto(airlineRepository.save(updateAirline));
    }

    @Override
    public boolean deleteById(Long id) {
        airlineRepository.deleteById(id);
        Airline deletedAirline = airlineRepository.findById(id).orElse(null);
        return deletedAirline == null;
    }
}