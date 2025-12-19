package com.example.final_project.mapper;

import com.example.final_project.dto.FlightDto;
import com.example.final_project.entity.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    @Mapping(target = "idDto", source = "id")
    @Mapping(target = "flightNumberDto", source = "flightNumber")
    @Mapping(target = "statusDto", source = "status")
    @Mapping(target = "departureAirportCodeDto", source = "departureAirportCode")
    @Mapping(target = "arrivalAirportCodeDto", source = "arrivalAirportCode")
    FlightDto toDto(Flight flight);

    @Mapping(target = "id", source = "idDto")
    @Mapping(target = "flightNumber", source = "flightNumberDto")
    @Mapping(target = "status", source = "statusDto")
    @Mapping(target = "departureAirportCode", source = "departureAirportCodeDto")
    @Mapping(target = "arrivalAirportCode", source = "arrivalAirportCodeDto")
    Flight toEntity(FlightDto flightDto);

    List<FlightDto> toDtoList(List<Flight> flights);
}