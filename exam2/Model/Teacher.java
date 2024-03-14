package com.example.exam2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    //ID , name , salary ( all should not be empty).
    @NotNull(message = "Id should not be empty")
    private  Integer id;

    @NotEmpty(message = "Name should not be empty ")
    private String name;

    @NotNull(message = "Salary should not be empty")
    private Double salary;






}
