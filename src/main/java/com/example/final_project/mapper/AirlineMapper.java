package com.example.final_project.mapper;

import com.example.final_project.dto.AirlineDto;
import com.example.final_project.entity.Airline;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirlineMapper {
    @Mapping(target = "idDto", source = "id")
    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "countryDto", source = "country")
    AirlineDto toDto(Airline airline);

    @Mapping(target = "id", source = "idDto")
    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "country", source = "countryDto")
    Airline toEntity(AirlineDto airlineDto);

    List<AirlineDto> toDtoList(List<Airline> airlines);
}