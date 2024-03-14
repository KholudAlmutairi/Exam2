package com.example.exam2.Controller;

import com.example.exam2.ApiRespones.ApiRespones;
import com.example.exam2.Model.Student;
import com.example.exam2.Model.Teacher;
import com.example.exam2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

   // Get all teachers
    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        ArrayList<Teacher> teachers=teacherService.getTeacher();
        return ResponseEntity.status(200).body(teachers);
    }

    //Add new teacher
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiRespones("Teacher added"));

    }

    //update teacher
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id,@RequestBody @Valid Teacher teacher,Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massage);
        }
        boolean isUpdate = teacherService.updateTeacher(id,teacher);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new ApiRespones("Teacher updated"));
        }
        return ResponseEntity.status(400).body(new ApiRespones("Teacher not found"));
    }

    //delete teacher
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){
        boolean isDeleted=teacherService.deleteTeacher(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiRespones("Teacher deleted"));
        }
        return ResponseEntity.status(400).body(new ApiRespones("Teacher not found"));
    }

//    Create an endpoint that takes a teacher id and returns one teacher .
@GetMapping("/geTeacher/{id}")
public  ResponseEntity getTeacher(@PathVariable int id){
    if(teacherService.getTeacher(id)==null){
        return ResponseEntity.status(400).body(new ApiRespones("Student name not found"));
    }
    return ResponseEntity.status(200).body(teacherService.getTeacher(id);
}

//    Create an endpoint that takes a salary and return all teachers who have this salary or above .









}
