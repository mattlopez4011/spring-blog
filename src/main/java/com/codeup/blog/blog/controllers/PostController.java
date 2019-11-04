package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String index(){
        return "Posts index page!";
    }

//    @RequestMapping(path = "/posts/{id}")
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable long id){
        return "Individual post #: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String formToCreatePost(){
        return "View form to create a new post!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost(@RequestParam String title, @RequestParam String body){
        return "Create new post: Title " + title + " Body: " + body;
    }

}
