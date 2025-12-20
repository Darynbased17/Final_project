package com.example.final_project.service;

import com.example.final_project.dto.AirportDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class AirportServiceTest {

    @Autowired
    private AirportService airportService;

    @Test
    void getAllTest() {
        AirportDto addAirport = AirportDto.builder()
                .codeDto("ALA")
                .nameDto("Almaty Airport")
                .cityDto("Almaty")
                .countryDto("Kazakhstan")
                .build();

        airportService.addAirport(addAirport);
        airportService.addAirport(addAirport);
        airportService.addAirport(addAirport);

        List<AirportDto> airportDtos = airportService.getAll();

        Assertions.assertNotNull(airportDtos);
        Assertions.assertNotEquals(0, airportDtos.size());

        for (AirportDto dto : airportDtos) {
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getIdDto());
            Assertions.assertNotNull(dto.getCodeDto());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getCityDto());
            Assertions.assertNotNull(dto.getCountryDto());
        }
    }

    @Test
    void getByIdTest() {
        AirportDto addAirport = AirportDto.builder()
                .codeDto("ALA")
                .nameDto("Test Airport")
                .cityDto("Test City")
                .countryDto("Test Country")
                .build();

        airportService.addAirport(addAirport);
        airportService.addAirport(addAirport);
        airportService.addAirport(addAirport);

        Random random = new Random();
        int randomId = random.nextInt(airportService.getAll().size());
        Long someId = airportService.getAll().get(randomId).getIdDto();

        AirportDto airportDto = airportService.getById(someId);

        Assertions.assertNotNull(airportDto);
        Assertions.assertNotNull(airportDto.getIdDto());
        Assertions.assertNotNull(airportDto.getCodeDto());
        Assertions.assertNotNull(airportDto.getNameDto());
        Assertions.assertNotNull(airportDto.getCityDto());
        Assertions.assertNotNull(airportDto.getCountryDto());

        AirportDto check = airportService.getById(-1L);
        Assertions.assertNull(check);
    }

    @Test
    void addTest() {
        AirportDto airportDto = AirportDto.builder()
                .codeDto("NQZ")
                .nameDto("Nur-Sultan Airport")
                .cityDto("Nur-Sultan")
                .countryDto("Kazakhstan")
                .build();

        AirportDto add = airportService.addAirport(airportDto);

        Assertions.assertNotNull(add);
        Assertions.assertNotNull(add.getIdDto());
        Assertions.assertNotNull(add.getCodeDto());
        Assertions.assertNotNull(add.getNameDto());
        Assertions.assertNotNull(add.getCityDto());
        Assertions.assertNotNull(add.getCountryDto());

        Assertions.assertEquals(add.getCodeDto(), airportDto.getCodeDto());
        Assertions.assertEquals(add.getNameDto(), airportDto.getNameDto());
        Assertions.assertEquals(add.getCityDto(), airportDto.getCityDto());
        Assertions.assertEquals(add.getCountryDto(), airportDto.getCountryDto());

        AirportDto added = airportService.getById(add.getIdDto());

        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getIdDto());
        Assertions.assertNotNull(added.getCodeDto());
        Assertions.assertNotNull(added.getNameDto());
        Assertions.assertNotNull(added.getCityDto());
        Assertions.assertNotNull(added.getCountryDto());

        Assertions.assertEquals(added.getIdDto(), add.getIdDto());
        Assertions.assertEquals(added.getCodeDto(), add.getCodeDto());
        Assertions.assertEquals(added.getNameDto(), add.getNameDto());
        Assertions.assertEquals(added.getCityDto(), add.getCityDto());
        Assertions.assertEquals(added.getCountryDto(), add.getCountryDto());
    }

    @Test
    void updateTest() {
        AirportDto addAirport = AirportDto.builder()
                .codeDto("ALA")
                .nameDto("Test Airport")
                .cityDto("Test City")
                .countryDto("Test Country")
                .build();

        airportService.addAirport(addAirport);
        airportService.addAirport(addAirport);
        airportService.addAirport(addAirport);

        Random random = new Random();
        int randomId = random.nextInt(airportService.getAll().size());
        Long someId = airportService.getAll().get(randomId).getIdDto();

        AirportDto updateAirport = AirportDto.builder()
                .idDto(someId)
                .codeDto("UPD")
                .nameDto("Updated Airport")
                .cityDto("Updated City")
                .countryDto("Updated Country")
                .build();

        AirportDto update = airportService.updateById(updateAirport.getIdDto(), updateAirport);

        Assertions.assertNotNull(update);
        Assertions.assertNotNull(update.getIdDto());
        Assertions.assertNotNull(update.getCodeDto());
        Assertions.assertNotNull(update.getNameDto());
        Assertions.assertNotNull(update.getCityDto());
        Assertions.assertNotNull(update.getCountryDto());

        Assertions.assertEquals(update.getIdDto(), updateAirport.getIdDto());
        Assertions.assertEquals(update.getCodeDto(), updateAirport.getCodeDto());
        Assertions.assertEquals(update.getNameDto(), updateAirport.getNameDto());
        Assertions.assertEquals(update.getCityDto(), updateAirport.getCityDto());
        Assertions.assertEquals(update.getCountryDto(), updateAirport.getCountryDto());

        AirportDto updated = airportService.getById(update.getIdDto());

        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getIdDto());
        Assertions.assertNotNull(updated.getCodeDto());
        Assertions.assertNotNull(updated.getNameDto());
        Assertions.assertNotNull(updated.getCityDto());
        Assertions.assertNotNull(updated.getCountryDto());

        Assertions.assertEquals(updated.getIdDto(), update.getIdDto());
        Assertions.assertEquals(updated.getCodeDto(), update.getCodeDto());
        Assertions.assertEquals(updated.getNameDto(), update.getNameDto());
        Assertions.assertEquals(updated.getCityDto(), update.getCityDto());
        Assertions.assertEquals(updated.getCountryDto(), update.getCountryDto());
    }

    @Test
    void deleteTest() {
        AirportDto addAirport = AirportDto.builder()
                .codeDto("ALA")
                .nameDto("Test Airport")
                .cityDto("Test City")
                .countryDto("Test Country")
                .build();

        airportService.addAirport(addAirport);
        airportService.addAirport(addAirport);
        airportService.addAirport(addAirport);

        Random random = new Random();
        int randomId = random.nextInt(airportService.getAll().size());
        Long someId = airportService.getAll().get(randomId).getIdDto();

        Assertions.assertTrue(airportService.deleteById(someId));

        AirportDto deleted = airportService.getById(someId);
        Assertions.assertNull(deleted);
    }
}