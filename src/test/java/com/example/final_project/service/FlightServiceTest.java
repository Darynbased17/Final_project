package com.example.final_project.service;

import com.example.final_project.dto.AirlineDto;
import com.example.final_project.dto.AirportDto;
import com.example.final_project.dto.FlightDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class FlightServiceTest {

    @Autowired
    private FlightService flightService;
    @Autowired
    private AirlineService airlineService;
    @Autowired
    private AirportService airportService;

    private void prepareData() {
        AirlineDto airline = AirlineDto.builder()
                .nameDto("Test Airline")
                .countryDto("Test Country")
                .build();
        airlineService.addAirline(airline);

        AirportDto airport1 = AirportDto.builder()
                .codeDto("ALA")
                .nameDto("Almaty")
                .cityDto("Almaty")
                .countryDto("Kazakhstan")
                .build();
        airportService.addAirport(airport1);

        AirportDto airport2 = AirportDto.builder()
                .codeDto("NQZ")
                .nameDto("Astana")
                .cityDto("Astana")
                .countryDto("Kazakhstan")
                .build();
        airportService.addAirport(airport2);
    }

    @Test
    void getAllTest() {
        prepareData();

        Long airlineId = airlineService.getAll().get(0).getIdDto();
        Long airport1Id = airportService.getAll().get(0).getIdDto();
        Long airport2Id = airportService.getAll().get(1).getIdDto();

        FlightDto flight = FlightDto.builder()
                .flightNumberDto("KC-001")
                .statusDto("SCHEDULED")
                .departureAirportCodeDto("ALA")
                .arrivalAirportCodeDto("NQZ")
                .airlineDto(AirlineDto.builder().idDto(airlineId).build())
                .airportsDto(List.of(
                        AirportDto.builder().idDto(airport1Id).build(),
                        AirportDto.builder().idDto(airport2Id).build()
                ))
                .build();

        flightService.addFlight(flight);

        List<FlightDto> flightDtos = flightService.getAll();

        Assertions.assertNotNull(flightDtos);
        Assertions.assertFalse(flightDtos.isEmpty());

        for (FlightDto dto : flightDtos) {
            Assertions.assertNotNull(dto.getIdDto());
            Assertions.assertNotNull(dto.getFlightNumberDto());
        }
    }

    @Test
    void getByIdTest() {
        prepareData();
        Long airlineId = airlineService.getAll().get(0).getIdDto();

        FlightDto flight = FlightDto.builder()
                .flightNumberDto("KC-002")
                .statusDto("SCHEDULED")
                .departureAirportCodeDto("ALA")
                .arrivalAirportCodeDto("NQZ")
                .airlineDto(AirlineDto.builder().idDto(airlineId).build())
                .build();

        FlightDto saved = flightService.addFlight(flight);
        FlightDto found = flightService.getById(saved.getIdDto());

        Assertions.assertNotNull(found);
        Assertions.assertEquals(saved.getIdDto(), found.getIdDto());

        Assertions.assertNull(flightService.getById(-1L));
    }

    @Test
    void addTest() {
        prepareData();
        Long airlineId = airlineService.getAll().get(0).getIdDto();

        FlightDto flightDto = FlightDto.builder()
                .flightNumberDto("KC-123")
                .statusDto("SCHEDULED")
                .departureAirportCodeDto("ALA")
                .arrivalAirportCodeDto("NQZ")
                .airlineDto(AirlineDto.builder().idDto(airlineId).build())
                .build();

        FlightDto added = flightService.addFlight(flightDto);

        Assertions.assertNotNull(added.getIdDto());
        Assertions.assertEquals("KC-123", added.getFlightNumberDto());
    }

    @Test
    void updateTest() {
        prepareData();
        Long airlineId = airlineService.getAll().get(0).getIdDto();

        FlightDto initial = flightService.addFlight(FlightDto.builder()
                .flightNumberDto("OLD-111")
                .airlineDto(AirlineDto.builder().idDto(airlineId).build())
                .build());

        FlightDto updateData = FlightDto.builder()
                .idDto(initial.getIdDto())
                .flightNumberDto("NEW-999")
                .statusDto("DELAYED")
                .airlineDto(AirlineDto.builder().idDto(airlineId).build())
                .build();

        FlightDto updated = flightService.updateById(initial.getIdDto(), updateData);

        Assertions.assertEquals("NEW-999", updated.getFlightNumberDto());
        Assertions.assertEquals("DELAYED", updated.getStatusDto());
    }

    @Test
    void deleteTest() {
        prepareData();
        Long airlineId = airlineService.getAll().get(0).getIdDto();

        FlightDto saved = flightService.addFlight(FlightDto.builder()
                .flightNumberDto("DEL-000")
                .airlineDto(AirlineDto.builder().idDto(airlineId).build())
                .build());

        Assertions.assertTrue(flightService.deleteById(saved.getIdDto()));
        Assertions.assertNull(flightService.getById(saved.getIdDto()));
    }
}