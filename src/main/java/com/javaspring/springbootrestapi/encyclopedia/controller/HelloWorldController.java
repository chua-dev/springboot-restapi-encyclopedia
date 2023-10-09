package com.javaspring.springbootrestapi.encyclopedia.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody // Tells Controller that the object return is serialized into JSON and pass back into HttpResponse Object

@RestController // @Controller + @ResponseBody
public class HelloWorldController {

    // HTTP GET Request
    // http://localhost:8080/hello_world
    @GetMapping("/hello_world") // map to this method
    public String getHelloWorld() {
        return "Hellow World";
    }
}
