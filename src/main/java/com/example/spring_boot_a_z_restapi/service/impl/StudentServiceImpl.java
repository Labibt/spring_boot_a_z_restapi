package com.example.spring_boot_a_z_restapi.service.impl;

import com.example.spring_boot_a_z_restapi.dto.AddStudentRequestDto;
import com.example.spring_boot_a_z_restapi.dto.StudentDto;
import com.example.spring_boot_a_z_restapi.entity.Student;
import com.example.spring_boot_a_z_restapi.repository.StudentRepository;
import com.example.spring_boot_a_z_restapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper patchModelMapper;
    private final ModelMapper modelMapper;


    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper,
                              @Qualifier("patchModelMapper") ModelMapper patchModelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
        this.patchModelMapper = patchModelMapper;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students= studentRepository.findAll();
        return students
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id: " + id));
        return modelMapper.map( student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        return modelMapper.map(studentRepository.save(modelMapper.map(addStudentRequestDto, Student.class)), StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not exist with id : " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id: " + id));
        modelMapper.map(addStudentRequestDto, student);
        return modelMapper.map(studentRepository.save(student), StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id: " + id));
        patchModelMapper.map(addStudentRequestDto, student);
        return modelMapper.map(studentRepository.save(student), StudentDto.class);
    }
}
