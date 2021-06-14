package org.launchcode.hellospring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    // Handles requests localhost:8080/hello?name=LaunchCode
    // @GetMapping("hello") only accepts GET requests
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value = "hello") // accepts both GET and POST requests
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Handles requests localhost:8080/hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    // Form that allows user to type in name and greet them with that data
    @GetMapping("form")
    // no @ResponseBody needed with templates
    public String helloForm() {
        return "form"; // assumes this is the name of the template
    }
}
