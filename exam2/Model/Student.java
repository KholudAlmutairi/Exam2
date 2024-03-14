package com.example.exam2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
   // ID , name , age , major  ( all should not be empty)

    //@NotEmpty(message = "Id should not be empty")
    @NotNull(message = "Id can not be null ")
    private Integer id;


    @NotEmpty(message = "Name should not be empty")
    private  String name;

    @NotNull(message = "Age can not be null ")
    //@NotEmpty(message = "Age should not be empty")
    private  Integer age;


    @NotEmpty(message = "Major should not be empty")
    private String major;







}
