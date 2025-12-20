package com.example.final_project.mapper;

import com.example.final_project.dto.AirlineDto;
import com.example.final_project.entity.Airline;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AirlineMapperTest {

    @Autowired
    private AirlineMapper airlineMapper;

    @Test
    void convertEntityToDtoTest() {
        Airline airlineEntity = new Airline(1L, "Air Astana", "Kazakhstan");

        AirlineDto airlineDto = airlineMapper.toDto(airlineEntity);

        Assertions.assertNotNull(airlineDto);
        Assertions.assertNotNull(airlineDto.getIdDto());
        Assertions.assertNotNull(airlineDto.getNameDto());
        Assertions.assertNotNull(airlineDto.getCountryDto());

        Assertions.assertEquals(airlineEntity.getId(), airlineDto.getIdDto());
        Assertions.assertEquals(airlineEntity.getName(), airlineDto.getNameDto());
        Assertions.assertEquals(airlineEntity.getCountry(), airlineDto.getCountryDto());
    }

    @Test
    void convertDtoToEntityTest() {
        AirlineDto airlineDto = new AirlineDto(1L, "Air Astana", "Kazakhstan");

        Airline airlineEntity = airlineMapper.toEntity(airlineDto);

        Assertions.assertNotNull(airlineEntity);
        Assertions.assertNotNull(airlineEntity.getId());
        Assertions.assertNotNull(airlineEntity.getName());
        Assertions.assertNotNull(airlineEntity.getCountry());

        Assertions.assertEquals(airlineDto.getIdDto(), airlineEntity.getId());
        Assertions.assertEquals(airlineDto.getNameDto(), airlineEntity.getName());
        Assertions.assertEquals(airlineDto.getCountryDto(), airlineEntity.getCountry());
    }

    @Test
    void convertEntityListToDtoListTest() {
        List<Airline> airlineEntityList = new ArrayList<>();
        airlineEntityList.add(new Airline(1L, "Air Astana", "Kazakhstan"));
        airlineEntityList.add(new Airline(2L, "Scat Airlines", "Kazakhstan"));
        airlineEntityList.add(new Airline(3L, "Turkish Airlines", "Turkey"));

        List<AirlineDto> airlineDtoList = airlineMapper.toDtoList(airlineEntityList);

        Assertions.assertNotNull(airlineDtoList);
        Assertions.assertNotEquals(0, airlineDtoList.size());
        Assertions.assertEquals(airlineEntityList.size(), airlineDtoList.size());

        for (int i = 0; i < airlineEntityList.size(); i++) {
            Airline airlineEntity = airlineEntityList.get(i);
            AirlineDto airlineDto = airlineDtoList.get(i);

            Assertions.assertNotNull(airlineDto);
            Assertions.assertNotNull(airlineDto.getIdDto());
            Assertions.assertNotNull(airlineDto.getNameDto());
            Assertions.assertNotNull(airlineDto.getCountryDto());

            Assertions.assertEquals(airlineEntity.getId(), airlineDto.getIdDto());
            Assertions.assertEquals(airlineEntity.getName(), airlineDto.getNameDto());
            Assertions.assertEquals(airlineEntity.getCountry(), airlineDto.getCountryDto());
        }
    }
}