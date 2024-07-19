package pl.jksnk.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jksnk.springboot.bean.Student;

@RestController
public class StudentController {


    //http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "Jakub",
                "Głowacki"
        );
        return student;
    }
}
