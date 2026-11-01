package com.smsk.healthcare.service;

import com.smsk.healthcare.entity.student;
import com.smsk.healthcare.repository.student_repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class student_service {

    private final student_repository ser;

    public List<student> get() {
        return ser.findAll();
    }
    public student insert(student new_student){
        return ser.save(new_student);
    }
    public student update(Long id,student new_student) {
        student old_id = ser.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        old_id.setName(new_student.getName());
        old_id.setAge(new_student.getAge());

        return ser.save(old_id);
    }
    public void delete(Long id){

        ser.deleteById(id);

    }
}