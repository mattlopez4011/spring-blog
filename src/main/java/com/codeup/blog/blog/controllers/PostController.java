package com.codeup.blog.blog.controllers;

import com.codeup.blog.blog.models.Post;
import com.codeup.blog.blog.models.PostDetails;
import com.codeup.blog.blog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PostController {
    private final PostRepository postDao;

//    Constuctor
    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }


    @GetMapping("/posts")
    public String index(Model viewModel){
        viewModel.addAttribute("posts", postDao.findAll());

        return "post";
    }

//    @RequestMapping(path = "/posts/{id}")
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model viewModel){

        viewModel.addAttribute("title", postDao.findById(id).get().getTitle());
        viewModel.addAttribute("body", postDao.findById(id).get().getBody());
        viewModel.addAttribute("id", id);

        return "showPost";
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

//    DELETE
    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam("id") String id){
        long deleteId = Long.parseLong(id);
        postDao.deleteById(deleteId);
        return "redirect:/posts";
    }
    // EDIT
    @GetMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("title", postDao.findById(id).get().getTitle());
        viewModel.addAttribute("body", postDao.findById(id).get().getBody());
        viewModel.addAttribute("id", id);
//        System.out.println("editId " + id);
        return "edit";
    }

    @PostMapping("/posts/edit")
    @ResponseBody
    public  String editPost(@RequestParam("id") Long id, @RequestParam("newBody") String newBody, @RequestParam("newTitle") String newTitle){
//        long editId = Long.parseLong(id);
//        postDao.
//        System.out.println(editId);
        return "id= " + id + "newBody= " + newBody + "newTitle= " + newTitle;
//        return "edit";
    }

//    Ono to one relationship
    @GetMapping("/post/detail-test/{id}")
    public String adDetailTest(@PathVariable long id, Model viewModel){
//        Post post = postDao.getOne(id);

        viewModel.addAttribute("post", postDao.getOne(id));
        return "detailTest";


    }

}
