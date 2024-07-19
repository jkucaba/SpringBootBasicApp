package pl.jksnk.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.jksnk.springboot.bean.Student;

import java.util.ArrayList;
import java.util.List;

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

    //http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Jakub", "Głowacki"));
        students.add(new Student(2, "Łukasz", "Słowacki"));
        students.add(new Student(3, "Patryk", "Prądnicki"));
        students.add(new Student(4, "Mikuś", "Wrocławski"));

        return students;
    }

    // Spring BOOT REST API with Path Variable
    //{id} - URI template variable
    // @PathVariable - annotation which indicates that a method parameter should be bound to a URI template variable
    //http://localhost:8080/students/1/Jakub/Głowacki

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String fName, @PathVariable("last-name") String lName){
        return new Student(studentId, fName, lName);
    }
}
