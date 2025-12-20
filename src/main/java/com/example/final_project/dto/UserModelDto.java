package com.example.final_project.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModelDto {
    private Long idDto;

    private String usernameDto;

    private String emailDto;
}