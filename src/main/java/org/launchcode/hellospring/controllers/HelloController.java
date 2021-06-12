package org.launchcode.hellospring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    // Handles request at localhost:8080/hello
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

}
