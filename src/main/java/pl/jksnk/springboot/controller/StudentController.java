package pl.jksnk.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    // String Boot REST API with Request Param
    //http://localhost:8080/students/query?id=1&firstName=Jakub&lastName=Głowacki

    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

    // Spring Boot REST API that handles HTTP Post Request
    // @ PostMapping - annotation for mapping HTTP POST requests onto specific handler methods / creating resource
    // @ RequestBody - annotation to bind the HTTP request/response body with a domain object in method parameter or return type

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student. getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }


    // Spring Boot REST API that handles HTTP Put Request
    // @ PutMapping - annotation for mapping HTTP PUT requests onto specific handler methods / updating resource

    @PutMapping("students/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }

    // Spring Boot REST API that handles HTTP Delete Request
    // @ DeleteMapping - annotation for mapping HTTP DELETE requests onto specific handler methods / deleting resource

    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);

        return "Student deleted successfully with id: " + studentId;
    }


}
