package com.ecommerce.studentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.studentsystem.model.Student;
import com.ecommerce.studentsystem.service.StudentService;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studService;

    @PostMapping("add")
    public ResponseEntity<String> newStudent(@RequestBody Student student){

        return studService.newStudent(student);
        
    }
    @GetMapping("retrieve")
    public ResponseEntity<List<Student>> getAllStudentDetails(){

        return studService.getAllStudentDetails();
    }

    @PostMapping("updateMailIdbyId")
    public ResponseEntity<String> updateMailId(@RequestParam String mailId, @RequestParam int Id){
        return studService.updateMailId(mailId,Id);

    }

    

    @DeleteMapping("delete")
    public ResponseEntity<String>  deleteStudentById(@PathVariable Integer id){

        return studService.deleteStudentById(id);
    }

    
}
