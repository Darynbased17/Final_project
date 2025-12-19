package com.example.final_project.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirlineDto {
    private Long idDto;
    private String nameDto;
    private String countryDto;
}