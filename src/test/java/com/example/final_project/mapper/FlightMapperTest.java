package com.example.final_project.mapper;

import com.example.final_project.dto.FlightDto;
import com.example.final_project.entity.Airline;
import com.example.final_project.entity.Airport;
import com.example.final_project.entity.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FlightMapperTest {

    @Autowired
    private FlightMapper flightMapper;

    @Test
    void convertEntityToDtoTest() {
        Airline airline = new Airline(1L, "Air Astana", "Kazakhstan");

        List<Airport> airports = new ArrayList<>();
        airports.add(new Airport(1L, "ALA", "Almaty Airport", "Almaty", "Kazakhstan"));
        airports.add(new Airport(2L, "NQZ", "Nursultan Nazarbayev Airport", "Nur-Sultan", "Kazakhstan"));

        Flight flightEntity = new Flight(1L, "KC-123", "SCHEDULED", "ALA", "NQZ", airline, airports);

        FlightDto flightDto = flightMapper.toDto(flightEntity);

        Assertions.assertNotNull(flightDto);
        Assertions.assertNotNull(flightDto.getIdDto());
        Assertions.assertNotNull(flightDto.getFlightNumberDto());
        Assertions.assertNotNull(flightDto.getStatusDto());
        Assertions.assertNotNull(flightDto.getDepartureAirportCodeDto());
        Assertions.assertNotNull(flightDto.getArrivalAirportCodeDto());

        Assertions.assertEquals(flightEntity.getId(), flightDto.getIdDto());
        Assertions.assertEquals(flightEntity.getFlightNumber(), flightDto.getFlightNumberDto());
        Assertions.assertEquals(flightEntity.getStatus(), flightDto.getStatusDto());
        Assertions.assertEquals(flightEntity.getDepartureAirportCode(), flightDto.getDepartureAirportCodeDto());
        Assertions.assertEquals(flightEntity.getArrivalAirportCode(), flightDto.getArrivalAirportCodeDto());
    }

    @Test
    void convertDtoToEntityTest() {
        FlightDto flightDto = new FlightDto(
                1L, "KC-123", "SCHEDULED", "ALA", "NQZ", null, null
        );

        Flight flightEntity = flightMapper.toEntity(flightDto);

        Assertions.assertNotNull(flightEntity);
        Assertions.assertNotNull(flightEntity.getId());
        Assertions.assertNotNull(flightEntity.getFlightNumber());
        Assertions.assertNotNull(flightEntity.getStatus());
        Assertions.assertNotNull(flightEntity.getDepartureAirportCode());
        Assertions.assertNotNull(flightEntity.getArrivalAirportCode());

        Assertions.assertEquals(flightDto.getIdDto(), flightEntity.getId());
        Assertions.assertEquals(flightDto.getFlightNumberDto(), flightEntity.getFlightNumber());
        Assertions.assertEquals(flightDto.getStatusDto(), flightEntity.getStatus());
        Assertions.assertEquals(flightDto.getDepartureAirportCodeDto(), flightEntity.getDepartureAirportCode());
        Assertions.assertEquals(flightDto.getArrivalAirportCodeDto(), flightEntity.getArrivalAirportCode());
    }

    @Test
    void convertEntityListToDtoListTest() {
        List<Flight> flightEntityList = new ArrayList<>();
        flightEntityList.add(new Flight(1L, "KC-123", "SCHEDULED", "ALA", "NQZ", null, null));
        flightEntityList.add(new Flight(2L, "KC-456", "DELAYED", "NQZ", "ALA", null, null));
        flightEntityList.add(new Flight(3L, "TK-789", "COMPLETED", "IST", "ALA", null, null));

        List<FlightDto> flightDtoList = flightMapper.toDtoList(flightEntityList);

        Assertions.assertNotNull(flightDtoList);
        Assertions.assertNotEquals(0, flightDtoList.size());
        Assertions.assertEquals(flightEntityList.size(), flightDtoList.size());

        for (int i = 0; i < flightEntityList.size(); i++) {
            Flight flightEntity = flightEntityList.get(i);
            FlightDto flightDto = flightDtoList.get(i);

            Assertions.assertNotNull(flightDto);
            Assertions.assertNotNull(flightDto.getIdDto());
            Assertions.assertNotNull(flightDto.getFlightNumberDto());
            Assertions.assertNotNull(flightDto.getStatusDto());
            Assertions.assertNotNull(flightDto.getDepartureAirportCodeDto());
            Assertions.assertNotNull(flightDto.getArrivalAirportCodeDto());

            Assertions.assertEquals(flightEntity.getId(), flightDto.getIdDto());
            Assertions.assertEquals(flightEntity.getFlightNumber(), flightDto.getFlightNumberDto());
            Assertions.assertEquals(flightEntity.getStatus(), flightDto.getStatusDto());
            Assertions.assertEquals(flightEntity.getDepartureAirportCode(), flightDto.getDepartureAirportCodeDto());
            Assertions.assertEquals(flightEntity.getArrivalAirportCode(), flightDto.getArrivalAirportCodeDto());
        }
    }
}