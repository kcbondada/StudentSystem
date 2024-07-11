package com.ecommerce.studentsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.studentsystem.model.Student;
import com.ecommerce.studentsystem.repository.StudentRepository;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    @SuppressWarnings("null")
    public ResponseEntity<String> newStudent(Student student) {

       
        studentRepository.save(student);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
        
    }

    public ResponseEntity<List<Student>> getAllStudentDetails() {
       try{
        return new ResponseEntity<>(studentRepository.findAll(),HttpStatus.OK);

       }catch(Exception e){
        e.printStackTrace();
       }
       return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("null")
    public ResponseEntity<String> deleteStudentById(Integer id) {

        studentRepository.deleteById(id);
       return new ResponseEntity<>("Deleted Successfully",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> updateMailId(String mailId, int id) {
        studentRepository.updateMailId(mailId,id);
       return new ResponseEntity<>("Updated MailId Successfully",HttpStatus.ACCEPTED);
    }



}
