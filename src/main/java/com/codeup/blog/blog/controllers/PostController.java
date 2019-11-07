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


//==============
// Exercise instructions
//One-to-Many Mini Exercise:
//        You will create a one-to-many relationship between the Post entity and the PostImage entity. Consider that...
//        - "One post may have many images."
//        - "Many images belong to one post."
//        1. In the relationship-practice branch of your Spring Blog's, add an entity of PostImage with the following fields:
//        id (typical primary key annotations)
//        image_title VARCHAR(100) NOT NULL
//        url VARCHAR(1000) NOT NULL - the url is for simple hot linking of images for now
//        post_id (a FK that will be created with the proper One-To-Many mapping)
//        2. Seed your posts table with a blog post about cats
//        3. Seed your post_images table with three images related to cats (use a hot-linked address for now).
//        4. Create a simple view that includes displays the title of the cat blog post the three images
