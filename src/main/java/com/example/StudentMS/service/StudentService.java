package com.example.StudentMS.service;

import com.example.StudentMS.dto.StudentDTO;
import com.example.StudentMS.entity.Student;
import com.example.StudentMS.repo.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper ;


    public String saveStudent(StudentDTO studentDTO){
        if (employeeRepo.existsById(employeeDTO.getEmpID())){
            return VarList.RSP_DUPLICATED;
        }else {
            employeeRepo.save(modelMapper.map(employeeDTO, Student.class));
            return VarList.RSP_SUCCESS;
        }
    }
    public String updateStudent(StudentDTO studentDTO){
        if (studentRepo.existsById(employeeDTO.getstuId())){
            studentRepo.save(modelMapper.map(employeeDTO, Student.class));
            return VarList.RSP_SUCCESS;

        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    public List<StudentDTO> getAllStudents(){
        List<Student> employeeList = studentRepo.findAll();
        return modelMapper.map(employeeList,new TypeToken<ArrayList<EmployeeDTO>>(){
        }.getType());
    }

    public StudentDTO searchStudent(int empID){
        if (studentRepo.existsById(empID)){
            Student employee =studentRepo.findById(empID).orElse(null);
            return modelMapper.map(employee,StudentDTO.class);
        }else {
            return null;
        }
    }
    public String deleteStudent(int empID){
        if (studentRepo.existsById(empID)){
            studentRepo.deleteById(empID);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
