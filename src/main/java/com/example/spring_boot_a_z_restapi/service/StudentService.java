package com.example.spring_boot_a_z_restapi.service;

import com.example.spring_boot_a_z_restapi.dto.AddStudentRequestDto;
import com.example.spring_boot_a_z_restapi.dto.StudentDto;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, AddStudentRequestDto addStudentRequestDto);
}
