package com.example.StudentMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private int stuId;
    private String stuName;
    private String email;
    private String address;
    private int grade;
}
