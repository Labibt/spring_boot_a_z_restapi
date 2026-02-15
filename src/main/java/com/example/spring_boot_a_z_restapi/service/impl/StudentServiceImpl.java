package com.example.spring_boot_a_z_restapi.service.impl;

import com.example.spring_boot_a_z_restapi.dto.StudentDto;
import com.example.spring_boot_a_z_restapi.entity.Student;
import com.example.spring_boot_a_z_restapi.repository.StudentRepository;
import com.example.spring_boot_a_z_restapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students= studentRepository.findAll();
        return students
                .stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return studentRepository.findById(id);
    }
}
