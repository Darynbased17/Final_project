package com.example.final_project.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightDto {
    private Long idDto;
    private String flightNumberDto;
    private String statusDto;
    private String departureAirportCodeDto;
    private String arrivalAirportCodeDto;
    private Long airlineIdDto;
    private List<Long> airportIdsDto;
}