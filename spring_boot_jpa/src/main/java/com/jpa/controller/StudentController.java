package com.jpa.controller;

import com.jpa.entity.Student;
import com.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Description:
 * User: purui_zhang
 * Date: 2019-02-21
 * Time: 18:33
 */
@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "save")
    public Object save(){
        Student student = new Student();
        student.setAge(18);
        student.setName("王大锤");
        studentRepository.save(student);
        return "成功啦啦啦";
    }

    @GetMapping(value = "findAll")
    public Object findAll(){
        List<Student> all = studentRepository.findAll();
        return all;
    }


}
