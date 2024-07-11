package com.ecommerce.studentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.studentsystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
    @Transactional
    @Modifying
    @Query(value = "UPDATE Student s SET s.mail_id = ?1 WHERE s.id = ?2",nativeQuery = true)
    void updateMailId(String mailId, int id);
    
}
