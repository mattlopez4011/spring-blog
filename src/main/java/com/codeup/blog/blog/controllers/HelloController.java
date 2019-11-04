package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

//    @GetMapping("/")
//    @ResponseBody
//    public String index(){
//        return "This is the landing page! :)";
//    }

    @GetMapping("/hello")
    @ResponseBody //Annotation needed for text response
    public String sayHello(){
        return "hey!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody //Annotation needed for text response
    public String sayHelloWithName(@PathVariable String name){
        System.out.println("hey " + name + "!");
        return "hey " + name + "!";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number){
        return number + " + 1 = " + (number + 1);
    }



}
