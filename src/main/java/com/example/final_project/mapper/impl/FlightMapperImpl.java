package com.example.final_project.mapper.impl;

import com.example.final_project.dto.AirlineDto;
import com.example.final_project.dto.AirportDto;
import com.example.final_project.dto.FlightDto;
import com.example.final_project.entity.Airline;
import com.example.final_project.entity.Airport;
import com.example.final_project.entity.Flight;
import com.example.final_project.mapper.FlightMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightMapperImpl implements FlightMapper {

    @Override
    public FlightDto toDto(Flight flight) {
        if (flight == null) {
            return null;
        }

        FlightDto.FlightDtoBuilder flightDto = FlightDto.builder();

        flightDto.idDto(flight.getId());
        flightDto.flightNumberDto(flight.getFlightNumber());
        flightDto.statusDto(flight.getStatus());
        flightDto.departureAirportCodeDto(flight.getDepartureAirportCode());
        flightDto.arrivalAirportCodeDto(flight.getArrivalAirportCode());
        flightDto.airlineDto(airlineToAirlineDto(flight.getAirline()));
        flightDto.airportsDto(airportListToAirportDtoList(flight.getAirports()));

        return flightDto.build();
    }

    @Override
    public Flight toEntity(FlightDto flightDto) {
        if (flightDto == null) {
            return null;
        }

        Flight.FlightBuilder flight = Flight.builder();

        flight.id(flightDto.getIdDto());
        flight.flightNumber(flightDto.getFlightNumberDto());
        flight.status(flightDto.getStatusDto());
        flight.departureAirportCode(flightDto.getDepartureAirportCodeDto());
        flight.arrivalAirportCode(flightDto.getArrivalAirportCodeDto());
        flight.airline(airlineDtoToAirline(flightDto.getAirlineDto()));
        flight.airports(airportDtoListToAirportList(flightDto.getAirportsDto()));

        return flight.build();
    }

    @Override
    public List<FlightDto> toDtoList(List<Flight> flights) {
        if (flights == null) {
            return null;
        }

        List<FlightDto> list = new ArrayList<>(flights.size());
        for (Flight flight : flights) {
            list.add(toDto(flight));
        }

        return list;
    }

    protected AirlineDto airlineToAirlineDto(Airline airline) {
        if (airline == null) {
            return null;
        }

        AirlineDto.AirlineDtoBuilder airlineDto = AirlineDto.builder();

        airlineDto.idDto(airline.getId());
        airlineDto.nameDto(airline.getName());
        airlineDto.countryDto(airline.getCountry());

        return airlineDto.build();
    }

    protected AirportDto airportToAirportDto(Airport airport) {
        if (airport == null) {
            return null;
        }

        AirportDto.AirportDtoBuilder airportDto = AirportDto.builder();

        airportDto.idDto(airport.getId());
        airportDto.codeDto(airport.getCode());
        airportDto.nameDto(airport.getName());
        airportDto.cityDto(airport.getCity());
        airportDto.countryDto(airport.getCountry());

        return airportDto.build();
    }

    protected List<AirportDto> airportListToAirportDtoList(List<Airport> list) {
        if (list == null) {
            return null;
        }

        List<AirportDto> list1 = new ArrayList<>(list.size());
        for (Airport airport : list) {
            list1.add(airportToAirportDto(airport));
        }

        return list1;
    }

    protected Airline airlineDtoToAirline(AirlineDto airlineDto) {
        if (airlineDto == null) {
            return null;
        }

        Airline.AirlineBuilder airline = Airline.builder();

        airline.id(airlineDto.getIdDto());
        airline.name(airlineDto.getNameDto());
        airline.country(airlineDto.getCountryDto());

        return airline.build();
    }

    protected Airport airportDtoToAirport(AirportDto airportDto) {
        if (airportDto == null) {
            return null;
        }

        Airport.AirportBuilder airport = Airport.builder();

        airport.id(airportDto.getIdDto());
        airport.code(airportDto.getCodeDto());
        airport.name(airportDto.getNameDto());
        airport.city(airportDto.getCityDto());
        airport.country(airportDto.getCountryDto());

        return airport.build();
    }

    protected List<Airport> airportDtoListToAirportList(List<AirportDto> list) {
        if (list == null) {
            return null;
        }

        List<Airport> list1 = new ArrayList<>(list.size());
        for (AirportDto airportDto : list) {
            list1.add(airportDtoToAirport(airportDto));
        }

        return list1;
    }
}