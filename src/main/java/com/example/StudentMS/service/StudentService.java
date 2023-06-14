package com.example.StudentMS.service;

import com.example.StudentMS.dto.StudentDTO;
import com.example.StudentMS.entity.Student;
import com.example.StudentMS.repo.StudentRepo;
import com.example.StudentMS.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper ;


    public String saveStudent(StudentDTO studentDTO){
        if (studentRepo.existsById(studentDTO.getStuId())){
            return VarList.RSP_DUPLICATED;
        }else {
            studentRepo.save(modelMapper.map(studentDTO, Student.class));
            return VarList.RSP_SUCCESS;
        }
    }
    public String updateStudent(StudentDTO studentDTO){
        if (studentRepo.existsById(studentDTO.getStuId())){
            studentRepo.save(modelMapper.map(studentDTO, Student.class));
            return VarList.RSP_SUCCESS;

        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    public List<StudentDTO> getAllStudents(){
        List<Student> studentList = studentRepo.findAll();
        return modelMapper.map(studentList,new TypeToken<ArrayList<StudentDTO>>(){}.getType());
    }

    public StudentDTO searchStudent(int stuID){
        if (studentRepo.existsById(stuID)){
            Student student =studentRepo.findById(stuID).orElse(null);
            return modelMapper.map(student,StudentDTO.class);
        }else {
            return null;
        }
    }
    public String deleteStudent(int stuID){
        if (studentRepo.existsById(stuID)){
            studentRepo.deleteById(stuID);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
