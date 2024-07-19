package pl.jksnk.springboot.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller // to make class as a controller
//@ResponseBody // the object is automatically serialized into JSON and passed back into the HttpResponse object
@RestController // combination of these two
public class HelloWorldController {

    // HTTP GET Request
    //http://localhost:8080/hello-world

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
