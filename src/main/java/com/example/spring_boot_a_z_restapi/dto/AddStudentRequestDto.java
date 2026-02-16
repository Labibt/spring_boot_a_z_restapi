package com.example.spring_boot_a_z_restapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddStudentRequestDto {
    private String name;
    private String email;
}
