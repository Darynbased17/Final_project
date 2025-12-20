package com.example.final_project.service;

import com.example.final_project.dto.AirlineDto;
import com.example.final_project.dto.AirportDto;
import com.example.final_project.dto.FlightDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class FlightServiceTest {

    @Autowired
    private FlightService flightService;
    @Autowired
    private AirlineService airlineService;
    @Autowired
    private AirportService airportService;

    @Test
    void getAllTest() {
        AirlineDto airlineDto = AirlineDto.builder()
                .nameDto("Test Airline")
                .countryDto("Test Country")
                .build();

        AirportDto airportDto1 = AirportDto.builder()
                .codeDto("ALA")
                .nameDto("Test Airport 1")
                .cityDto("Test City 1")
                .countryDto("Test Country 1")
                .build();

        AirportDto airportDto2 = AirportDto.builder()
                .codeDto("NQZ")
                .nameDto("Test Airport 2")
                .cityDto("Test City 2")
                .countryDto("Test Country 2")
                .build();

        airlineService.addAirline(airlineDto);
        airportService.addAirport(airportDto1);
        airportService.addAirport(airportDto2);

        FlightDto addFlight = FlightDto.builder()
                .flightNumberDto("KC-001")
                .statusDto("SCHEDULED")
                .departureAirportCodeDto("ALA")
                .arrivalAirportCodeDto("NQZ")
                .airlineIdDto(1L)
                .airportIdsDto(List.of(1L, 2L))
                .build();

        flightService.addFlight(addFlight);
        flightService.addFlight(addFlight);
        flightService.addFlight(addFlight);

        List<FlightDto> flightDtos = flightService.getAll();

        Assertions.assertNotNull(flightDtos);
        Assertions.assertNotEquals(0, flightDtos.size());

        for (FlightDto dto : flightDtos) {
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getIdDto());
            Assertions.assertNotNull(dto.getFlightNumberDto());
            Assertions.assertNotNull(dto.getStatusDto());
            Assertions.assertNotNull(dto.getDepartureAirportCodeDto());
            Assertions.assertNotNull(dto.getArrivalAirportCodeDto());
        }
    }

    @Test
    void getByIdTest() {
        AirlineDto airlineDto = AirlineDto.builder()
                .nameDto("Test Airline")
                .countryDto("Test Country")
                .build();

        AirportDto airportDto1 = AirportDto.builder()
                .codeDto("ALA")
                .nameDto("Test Airport 1")
                .cityDto("Test City 1")
                .countryDto("Test Country 1")
                .build();

        AirportDto airportDto2 = AirportDto.builder()
                .codeDto("NQZ")
                .nameDto("Test Airport 2")
                .cityDto("Test City 2")
                .countryDto("Test Country 2")
                .build();

        airlineService.addAirline(airlineDto);
        airportService.addAirport(airportDto1);
        airportService.addAirport(airportDto2);

        FlightDto addFlight = FlightDto.builder()
                .flightNumberDto("KC-001")
                .statusDto("SCHEDULED")
                .departureAirportCodeDto("ALA")
                .arrivalAirportCodeDto("NQZ")
                .airlineIdDto(1L)
                .airportIdsDto(List.of(1L, 2L))
                .build();

        flightService.addFlight(addFlight);
        flightService.addFlight(addFlight);
        flightService.addFlight(addFlight);

        Random random = new Random();
        int randomId = random.nextInt(flightService.getAll().size());
        Long someId = flightService.getAll().get(randomId).getIdDto();

        FlightDto flightDto = flightService.getById(someId);

        Assertions.assertNotNull(flightDto);
        Assertions.assertNotNull(flightDto.getIdDto());
        Assertions.assertNotNull(flightDto.getFlightNumberDto());
        Assertions.assertNotNull(flightDto.getStatusDto());
        Assertions.assertNotNull(flightDto.getDepartureAirportCodeDto());
        Assertions.assertNotNull(flightDto.getArrivalAirportCodeDto());

        FlightDto check = flightService.getById(-1L);
        Assertions.assertNull(check);
    }

    @Test
    void addTest() {
        AirlineDto airlineDto = AirlineDto.builder()
                .nameDto("Test Airline")
                .countryDto("Test Country")
                .build();

        AirportDto airportDto1 = AirportDto.builder()
                .codeDto("ALA")
                .nameDto("Test Airport 1")
                .cityDto("Test City 1")
                .countryDto("Test Country 1")
                .build();

        AirportDto airportDto2 = AirportDto.builder()
                .codeDto("NQZ")
                .nameDto("Test Airport 2")
                .cityDto("Test City 2")
                .countryDto("Test Country 2")
                .build();

        airlineService.addAirline(airlineDto);
        airportService.addAirport(airportDto1);
        airportService.addAirport(airportDto2);

        FlightDto flightDto = FlightDto.builder()
                .flightNumberDto("KC-123")
                .statusDto("SCHEDULED")
                .departureAirportCodeDto("ALA")
                .arrivalAirportCodeDto("NQZ")
                .airlineIdDto(1L)
                .airportIdsDto(List.of(1L, 2L))
                .build();

        FlightDto add = flightService.addFlight(flightDto);

        Assertions.assertNotNull(add);
        Assertions.assertNotNull(add.getIdDto());
        Assertions.assertNotNull(add.getFlightNumberDto());
        Assertions.assertNotNull(add.getStatusDto());
        Assertions.assertNotNull(add.getDepartureAirportCodeDto());
        Assertions.assertNotNull(add.getArrivalAirportCodeDto());

        Assertions.assertEquals(add.getFlightNumberDto(), flightDto.getFlightNumberDto());
        Assertions.assertEquals(add.getStatusDto(), flightDto.getStatusDto());
        Assertions.assertEquals(add.getDepartureAirportCodeDto(), flightDto.getDepartureAirportCodeDto());
        Assertions.assertEquals(add.getArrivalAirportCodeDto(), flightDto.getArrivalAirportCodeDto());

        FlightDto added = flightService.getById(add.getIdDto());

        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getIdDto());
        Assertions.assertNotNull(added.getFlightNumberDto());
        Assertions.assertNotNull(added.getStatusDto());
        Assertions.assertNotNull(added.getDepartureAirportCodeDto());
        Assertions.assertNotNull(added.getArrivalAirportCodeDto());

        Assertions.assertEquals(added.getIdDto(), add.getIdDto());
        Assertions.assertEquals(added.getFlightNumberDto(), add.getFlightNumberDto());
        Assertions.assertEquals(added.getStatusDto(), add.getStatusDto());
        Assertions.assertEquals(added.getDepartureAirportCodeDto(), add.getDepartureAirportCodeDto());
        Assertions.assertEquals(added.getArrivalAirportCodeDto(), add.getArrivalAirportCodeDto());
    }

    @Test
    void updateTest() {
        AirlineDto airlineDto = AirlineDto.builder()
                .nameDto("Test Airline")
                .countryDto("Test Country")
                .build();

        AirportDto airportDto1 = AirportDto.builder()
                .codeDto("ALA")
                .nameDto("Test Airport 1")
                .cityDto("Test City 1")
                .countryDto("Test Country 1")
                .build();

        AirportDto airportDto2 = AirportDto.builder()
                .codeDto("NQZ")
                .nameDto("Test Airport 2")
                .cityDto("Test City 2")
                .countryDto("Test Country 2")
                .build();

        airlineService.addAirline(airlineDto);
        airportService.addAirport(airportDto1);
        airportService.addAirport(airportDto2);

        FlightDto addFlight = FlightDto.builder()
                .flightNumberDto("KC-001")
                .statusDto("SCHEDULED")
                .departureAirportCodeDto("ALA")
                .arrivalAirportCodeDto("NQZ")
                .airlineIdDto(1L)
                .airportIdsDto(List.of(1L, 2L))
                .build();

        flightService.addFlight(addFlight);
        flightService.addFlight(addFlight);
        flightService.addFlight(addFlight);

        Random random = new Random();
        int randomId = random.nextInt(flightService.getAll().size());
        Long someId = flightService.getAll().get(randomId).getIdDto();

        FlightDto updateFlight = FlightDto.builder()
                .idDto(someId)
                .flightNumberDto("KC-999")
                .statusDto("DELAYED")
                .departureAirportCodeDto("NQZ")
                .arrivalAirportCodeDto("ALA")
                .airlineIdDto(1L)
                .airportIdsDto(List.of(1L, 2L))
                .build();

        FlightDto update = flightService.updateById(updateFlight.getIdDto(), updateFlight);

        Assertions.assertNotNull(update);
        Assertions.assertNotNull(update.getIdDto());
        Assertions.assertNotNull(update.getFlightNumberDto());
        Assertions.assertNotNull(update.getStatusDto());
        Assertions.assertNotNull(update.getDepartureAirportCodeDto());
        Assertions.assertNotNull(update.getArrivalAirportCodeDto());

        Assertions.assertEquals(update.getIdDto(), updateFlight.getIdDto());
        Assertions.assertEquals(update.getFlightNumberDto(), updateFlight.getFlightNumberDto());
        Assertions.assertEquals(update.getStatusDto(), updateFlight.getStatusDto());
        Assertions.assertEquals(update.getDepartureAirportCodeDto(), updateFlight.getDepartureAirportCodeDto());
        Assertions.assertEquals(update.getArrivalAirportCodeDto(), updateFlight.getArrivalAirportCodeDto());

        FlightDto updated = flightService.getById(update.getIdDto());

        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getIdDto());
        Assertions.assertNotNull(updated.getFlightNumberDto());
        Assertions.assertNotNull(updated.getStatusDto());
        Assertions.assertNotNull(updated.getDepartureAirportCodeDto());
        Assertions.assertNotNull(updated.getArrivalAirportCodeDto());

        Assertions.assertEquals(updated.getIdDto(), update.getIdDto());
        Assertions.assertEquals(updated.getFlightNumberDto(), update.getFlightNumberDto());
        Assertions.assertEquals(updated.getStatusDto(), update.getStatusDto());
        Assertions.assertEquals(updated.getDepartureAirportCodeDto(), update.getDepartureAirportCodeDto());
        Assertions.assertEquals(updated.getArrivalAirportCodeDto(), update.getArrivalAirportCodeDto());
    }

    @Test
    void deleteTest() {
        AirlineDto airlineDto = AirlineDto.builder()
                .nameDto("Test Airline")
                .countryDto("Test Country")
                .build();

        AirportDto airportDto1 = AirportDto.builder()
                .codeDto("ALA")
                .nameDto("Test Airport 1")
                .cityDto("Test City 1")
                .countryDto("Test Country 1")
                .build();

        AirportDto airportDto2 = AirportDto.builder()
                .codeDto("NQZ")
                .nameDto("Test Airport 2")
                .cityDto("Test City 2")
                .countryDto("Test Country 2")
                .build();

        airlineService.addAirline(airlineDto);
        airportService.addAirport(airportDto1);
        airportService.addAirport(airportDto2);

        FlightDto addFlight = FlightDto.builder()
                .flightNumberDto("KC-001")
                .statusDto("SCHEDULED")
                .departureAirportCodeDto("ALA")
                .arrivalAirportCodeDto("NQZ")
                .airlineIdDto(1L)
                .airportIdsDto(List.of(1L, 2L))
                .build();

        flightService.addFlight(addFlight);
        flightService.addFlight(addFlight);
        flightService.addFlight(addFlight);

        Random random = new Random();
        int randomId = random.nextInt(flightService.getAll().size());
        Long someId = flightService.getAll().get(randomId).getIdDto();

        Assertions.assertTrue(flightService.deleteById(someId));

        FlightDto deleted = flightService.getById(someId);
        Assertions.assertNull(deleted);
    }
}