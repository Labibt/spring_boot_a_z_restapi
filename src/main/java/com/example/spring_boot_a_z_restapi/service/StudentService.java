package com.example.spring_boot_a_z_restapi.service;

import com.example.spring_boot_a_z_restapi.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);
}
