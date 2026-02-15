package com.example.spring_boot_a_z_restapi.repository;

import com.example.spring_boot_a_z_restapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
