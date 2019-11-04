package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "Posts index page!";
    }

    @RequestMapping(path = "/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable int id){
        return "Individual post #: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String formToCreatePost(){
        return "View form to create a new post!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost(){
        return "Create new post";
    }

}
