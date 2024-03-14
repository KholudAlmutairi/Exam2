package com.example.exam2.Controller;

import com.example.exam2.ApiRespones.ApiRespones;
import com.example.exam2.Model.Student;
import com.example.exam2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController
{
    private final StudentService studentService;


    //Get all students
    @GetMapping("/get")
    public ResponseEntity getStudent(){
        ArrayList<Student> students=studentService.getStudent();
        return ResponseEntity.status(200).body(students);
    }


    //Add new student
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){
        if(errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiRespones("Student added"));

    }

    //update student
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id,@RequestBody @Valid Student student,Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }
        boolean isUpdate = studentService.updateStudent(id, student);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new ApiRespones("Student updated"));
        }
        return ResponseEntity.status(400).body(new ApiRespones("Student not found"));
    }
    //Delete student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){
        boolean isDeleted=studentService.deleteStudent(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiRespones("Student deleted"));
        }
        return ResponseEntity.status(400).body(new ApiRespones("Student not found"));
    }

    //Create an endpoint that takes a student name and returns one student .
    @GetMapping("/getStudentName/{name}")
    public  ResponseEntity getStudentName(@PathVariable String name){
        if(studentService.getStudentName(name)==null){
             return ResponseEntity.status(400).body(new ApiRespones("Student name not found"));
        }
        return ResponseEntity.status(200).body(studentService.getStudentName(name));
    }

    //Create an endpoint that takes a major and returns all students who have this major.

    @GetMapping("/getStudentsbyMajor/{major}")
     public ResponseEntity<ApiRespones> getStudentsbyMajor(@PathVariable String major){
        if(studentService.getStudentsbyMajor(major)==null){
            return ResponseEntity.status(400).body(new ApiRespones("Student major not found"));
       }

       // return ResponseEntity.status(200).body(studentService.getStudentsbyMajor(major));

     }









}












