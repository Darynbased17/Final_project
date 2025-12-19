package com.example.final_project.mapper;

import com.example.final_project.dto.AirportDto;
import com.example.final_project.entity.Airport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirportMapper {
    @Mapping(target = "idDto", source = "id")
    @Mapping(target = "codeDto", source = "code")
    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "cityDto", source = "city")
    @Mapping(target = "countryDto", source = "country")
    AirportDto toDto(Airport airport);

    @Mapping(target = "id", source = "idDto")
    @Mapping(target = "code", source = "codeDto")
    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "city", source = "cityDto")
    @Mapping(target = "country", source = "countryDto")
    Airport toEntity(AirportDto airportDto);

    List<AirportDto> toDtoList(List<Airport> airports);
}