package dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportDto {
    private Long idDto;
    private String codeDto;
    private String nameDto;
    private String cityDto;
    private String countryDto;
}