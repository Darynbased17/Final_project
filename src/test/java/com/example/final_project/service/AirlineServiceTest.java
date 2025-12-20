package com.example.final_project.service;

import com.example.final_project.dto.AirlineDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class AirlineServiceTest {

    @Autowired
    private AirlineService airlineService;

    @Test
    void getAllTest() {
        AirlineDto addAirline = AirlineDto.builder()
                .nameDto("Air Astana")
                .countryDto("Kazakhstan")
                .build();

        airlineService.addAirline(addAirline);
        airlineService.addAirline(addAirline);
        airlineService.addAirline(addAirline);

        List<AirlineDto> airlineDtos = airlineService.getAll();

        Assertions.assertNotNull(airlineDtos);
        Assertions.assertNotEquals(0, airlineDtos.size());

        for (AirlineDto dto : airlineDtos) {
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getIdDto());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getCountryDto());
        }
    }

    @Test
    void getByIdTest() {
        AirlineDto addAirline = AirlineDto.builder()
                .nameDto("Test Airline")
                .countryDto("Test Country")
                .build();

        airlineService.addAirline(addAirline);
        airlineService.addAirline(addAirline);
        airlineService.addAirline(addAirline);

        Random random = new Random();
        int randomId = random.nextInt(airlineService.getAll().size());
        Long someId = airlineService.getAll().get(randomId).getIdDto();

        AirlineDto airlineDto = airlineService.getById(someId);

        Assertions.assertNotNull(airlineDto);
        Assertions.assertNotNull(airlineDto.getIdDto());
        Assertions.assertNotNull(airlineDto.getNameDto());
        Assertions.assertNotNull(airlineDto.getCountryDto());

        AirlineDto check = airlineService.getById(-1L);
        Assertions.assertNull(check);
    }

    @Test
    void addTest() {
        AirlineDto airlineDto = AirlineDto.builder()
                .nameDto("Test Airline")
                .countryDto("Test Country")
                .build();

        AirlineDto add = airlineService.addAirline(airlineDto);

        Assertions.assertNotNull(add);
        Assertions.assertNotNull(add.getIdDto());
        Assertions.assertNotNull(add.getNameDto());
        Assertions.assertNotNull(add.getCountryDto());

        Assertions.assertEquals(add.getNameDto(), airlineDto.getNameDto());
        Assertions.assertEquals(add.getCountryDto(), airlineDto.getCountryDto());

        AirlineDto added = airlineService.getById(add.getIdDto());

        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getIdDto());
        Assertions.assertNotNull(added.getNameDto());
        Assertions.assertNotNull(added.getCountryDto());

        Assertions.assertEquals(added.getIdDto(), add.getIdDto());
        Assertions.assertEquals(added.getNameDto(), add.getNameDto());
        Assertions.assertEquals(added.getCountryDto(), add.getCountryDto());
    }

    @Test
    void updateTest() {
        AirlineDto addAirline = AirlineDto.builder()
                .nameDto("Test Airline")
                .countryDto("Test Country")
                .build();

        airlineService.addAirline(addAirline);
        airlineService.addAirline(addAirline);
        airlineService.addAirline(addAirline);

        Random random = new Random();
        int randomId = random.nextInt(airlineService.getAll().size());
        Long someId = airlineService.getAll().get(randomId).getIdDto();

        AirlineDto updateAirline = AirlineDto.builder()
                .idDto(someId)
                .nameDto("Updated Airline Name")
                .countryDto("Updated Country")
                .build();

        AirlineDto update = airlineService.updateById(updateAirline.getIdDto(), updateAirline);

        Assertions.assertNotNull(update);
        Assertions.assertNotNull(update.getIdDto());
        Assertions.assertNotNull(update.getNameDto());
        Assertions.assertNotNull(update.getCountryDto());

        Assertions.assertEquals(update.getIdDto(), updateAirline.getIdDto());
        Assertions.assertEquals(update.getNameDto(), updateAirline.getNameDto());
        Assertions.assertEquals(update.getCountryDto(), updateAirline.getCountryDto());

        AirlineDto updated = airlineService.getById(update.getIdDto());

        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getIdDto());
        Assertions.assertNotNull(updated.getNameDto());
        Assertions.assertNotNull(updated.getCountryDto());

        Assertions.assertEquals(updated.getIdDto(), update.getIdDto());
        Assertions.assertEquals(updated.getNameDto(), update.getNameDto());
        Assertions.assertEquals(updated.getCountryDto(), update.getCountryDto());
    }

    @Test
    void deleteTest() {
        AirlineDto addAirline = AirlineDto.builder()
                .nameDto("Test Airline")
                .countryDto("Test Country")
                .build();

        airlineService.addAirline(addAirline);
        airlineService.addAirline(addAirline);
        airlineService.addAirline(addAirline);

        Random random = new Random();
        int randomId = random.nextInt(airlineService.getAll().size());
        Long someId = airlineService.getAll().get(randomId).getIdDto();

        Assertions.assertTrue(airlineService.deleteById(someId));

        AirlineDto deleted = airlineService.getById(someId);
        Assertions.assertNull(deleted);
    }
}