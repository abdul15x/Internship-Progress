package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
public class Hellocontroller {
    @RestController
    public static class HelloWorldController {


        @RequestMapping("/home")
        public String helloWorld() {


            return "Hello Interns";
        }
    }
}
