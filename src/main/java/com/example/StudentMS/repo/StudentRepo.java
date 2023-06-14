package com.example.StudentMS.repo;

import com.example.StudentMS.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
