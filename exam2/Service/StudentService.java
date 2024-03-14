package com.example.exam2.Service;

import com.example.exam2.Model.Student;
import com.example.exam2.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students=new ArrayList<>();

    //Get all students
    public ArrayList<Student> getStudent(){
        return students;
    }
    //Add new student
    public void addStudent(Student student){
        students.add(student);
    }

    //update student
    public boolean updateStudent(int id,Student student){
        for(int i=0; i<students.size();i++){
            if(students.get(i).getId()==id){
                students.set(i,student);
                return true;
            }

        }
        return false;
    }



   // delete student
    public boolean deleteStudent(int id){
        for(int i=0; i<students.size();i++){
            if(students.get(i).getId()==id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    //Create an endpoint that takes a student name and returns one student .

    public Student getStudentName(String name){
        for(Student student:students )
         if(student.getName().equalsIgnoreCase(name)){
             return student;
         }
        return null;
    }

    //Create an endpoint that takes a major and returns all students who have this major.
    public Student getStudentsbyMajor(String major){
        for (Student student:students)
            if(student.getMajor().equalsIgnoreCase(major)){
                return student;
            }
        return null;

    }






}
