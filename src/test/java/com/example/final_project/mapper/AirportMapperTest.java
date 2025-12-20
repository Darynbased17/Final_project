package com.example.final_project.mapper;

import com.example.final_project.dto.AirportDto;
import com.example.final_project.entity.Airport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AirportMapperTest {

    @Autowired
    private AirportMapper airportMapper;

    @Test
    void convertEntityToDtoTest() {
        Airport airportEntity = new Airport(1L, "ALA", "Almaty Airport", "Almaty", "Kazakhstan");

        AirportDto airportDto = airportMapper.toDto(airportEntity);

        Assertions.assertNotNull(airportDto);
        Assertions.assertNotNull(airportDto.getIdDto());
        Assertions.assertNotNull(airportDto.getCodeDto());
        Assertions.assertNotNull(airportDto.getNameDto());
        Assertions.assertNotNull(airportDto.getCityDto());
        Assertions.assertNotNull(airportDto.getCountryDto());

        Assertions.assertEquals(airportEntity.getId(), airportDto.getIdDto());
        Assertions.assertEquals(airportEntity.getCode(), airportDto.getCodeDto());
        Assertions.assertEquals(airportEntity.getName(), airportDto.getNameDto());
        Assertions.assertEquals(airportEntity.getCity(), airportDto.getCityDto());
        Assertions.assertEquals(airportEntity.getCountry(), airportDto.getCountryDto());
    }

    @Test
    void convertDtoToEntityTest() {
        AirportDto airportDto = new AirportDto(1L, "ALA", "Almaty Airport", "Almaty", "Kazakhstan");

        Airport airportEntity = airportMapper.toEntity(airportDto);

        Assertions.assertNotNull(airportEntity);
        Assertions.assertNotNull(airportEntity.getId());
        Assertions.assertNotNull(airportEntity.getCode());
        Assertions.assertNotNull(airportEntity.getName());
        Assertions.assertNotNull(airportEntity.getCity());
        Assertions.assertNotNull(airportEntity.getCountry());

        Assertions.assertEquals(airportDto.getIdDto(), airportEntity.getId());
        Assertions.assertEquals(airportDto.getCodeDto(), airportEntity.getCode());
        Assertions.assertEquals(airportDto.getNameDto(), airportEntity.getName());
        Assertions.assertEquals(airportDto.getCityDto(), airportEntity.getCity());
        Assertions.assertEquals(airportDto.getCountryDto(), airportEntity.getCountry());
    }

    @Test
    void convertEntityListToDtoListTest() {
        List<Airport> airportEntityList = new ArrayList<>();
        airportEntityList.add(new Airport(1L, "ALA", "Almaty Airport", "Almaty", "Kazakhstan"));
        airportEntityList.add(new Airport(2L, "NQZ", "Nursultan Nazarbayev Airport", "Nur-Sultan", "Kazakhstan"));
        airportEntityList.add(new Airport(3L, "IST", "Istanbul Airport", "Istanbul", "Turkey"));

        List<AirportDto> airportDtoList = airportMapper.toDtoList(airportEntityList);

        Assertions.assertNotNull(airportDtoList);
        Assertions.assertNotEquals(0, airportDtoList.size());
        Assertions.assertEquals(airportEntityList.size(), airportDtoList.size());

        for (int i = 0; i < airportEntityList.size(); i++) {
            Airport airportEntity = airportEntityList.get(i);
            AirportDto airportDto = airportDtoList.get(i);

            Assertions.assertNotNull(airportDto);
            Assertions.assertNotNull(airportDto.getIdDto());
            Assertions.assertNotNull(airportDto.getCodeDto());
            Assertions.assertNotNull(airportDto.getNameDto());
            Assertions.assertNotNull(airportDto.getCityDto());
            Assertions.assertNotNull(airportDto.getCountryDto());

            Assertions.assertEquals(airportEntity.getId(), airportDto.getIdDto());
            Assertions.assertEquals(airportEntity.getCode(), airportDto.getCodeDto());
            Assertions.assertEquals(airportEntity.getName(), airportDto.getNameDto());
            Assertions.assertEquals(airportEntity.getCity(), airportDto.getCityDto());
            Assertions.assertEquals(airportEntity.getCountry(), airportDto.getCountryDto());
        }
    }
}