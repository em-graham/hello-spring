package org.launchcode.hellospring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello") // every single method should begin with /hello
public class HelloController {

    // Handles request at localhost:8080/hello/hello
//    @GetMapping("hello")
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // Handles request at localhost:8080/hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests localhost:8080/hello/hello?name=LaunchCode
    // @GetMapping("hello") only accepts GET requests
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}) // accepts both GET and POST requests
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests localhost:8080/hello/hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // Form that allows user to type in name and greet them with that data
    // hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
