package com.codeup.blog.blog.controllers;

import com.codeup.blog.blog.models.Post;
import com.codeup.blog.blog.models.PostImage;
import com.codeup.blog.blog.models.Tag;
import com.codeup.blog.blog.models.User;
import com.codeup.blog.blog.repositories.PostImageRepository;
import com.codeup.blog.blog.repositories.PostRepository;
import com.codeup.blog.blog.repositories.TagRepository;
import com.codeup.blog.blog.repositories.UserRepository;
import com.codeup.blog.blog.services.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final PostImageRepository postImageDao;
    private final TagRepository tagDao;
    private final UserRepository userDao;

    @Autowired
    EmailServices emailServices;

//   Dao Constructor
    public PostController(PostRepository postDao, PostImageRepository postImageDao, TagRepository tagDao, UserRepository userDao){

        this.postDao = postDao;
        this.postImageDao = postImageDao;
        this.tagDao = tagDao;
        this.userDao = userDao;
    }


    @GetMapping("/posts")
    public String index(Model viewModel){
        viewModel.addAttribute("posts", postDao.findAll());

        return "post";
    }

//    @RequestMapping(path = "/posts/{id}")
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model viewModel){

        viewModel.addAttribute("post", postDao.getOne(id));
//        viewModel.addAttribute("title", postDao.findById(id).get().getTitle());
//        viewModel.addAttribute("body", postDao.findById(id).get().getBody());
//        viewModel.addAttribute("email", postDao.findById(id).get().getUser().getEmail());
//        viewModel.addAttribute("id", id);

        return "showPost";
    }

//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String formToCreatePost(){
//        return "View form to create a new post!";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String createNewPost(@RequestParam String title, @RequestParam String body){
//        return "Create new post: Title " + title + " Body: " + body;
//    }

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
        viewModel.addAttribute("post", postDao.getOne(id));
//        System.out.println("editId " + id);
        return "edit";
    }

    // ======== EDIT POST
    @PostMapping("/posts/edit/{id}")
    public  String editPost(@PathVariable long id, @RequestParam String newBody, @RequestParam String newTitle){
//        long editId = Long.parseLong(id);
        Post post = postDao.getOne(id);
        post.setTitle(newTitle); // Setting new title
        post.setBody(newBody); // Setting new body
//        post.setTags(tagCrazy); // Setting new tag

        postDao.save(post);

//        viewModel.addAttribute("look", tagDao.getOne(id));  // check what this returns
//        System.out.println(editId);
//        return "id= " + id + "newBody= " + newBody + "newTitle= " + newTitle;
        return "redirect:/posts/edit/" + post.getId(); // Returns post user is editing

    }

//    Ono to one relationship
    @GetMapping("/post/detail-test/{id}")
    public String adDetailTest(@PathVariable long id, Model viewModel){
//        Post post = postDao.getOne(id);

        viewModel.addAttribute("post", postDao.getOne(id));
        return "detailTest";


    }

    @GetMapping("/posts/{id}/add-image")
    public String catImages(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("post", postDao.getOne(id));
//        System.out.println(postDao.findById(id));
        return "/posts/test";
    }

    // TESTING ONE TO MANY RELATIONSHIP...
    @PostMapping("/posts/{id}/add-image")
    public String addCatImage(
            @PathVariable long id,
            @RequestParam String title,
            @RequestParam String url
            ) {

        PostImage newImage = new PostImage(title, url);
        newImage.setPost(postDao.getOne(id));
        postImageDao.save(newImage);

        return "redirect:/posts/{id}/add-image";
    }

    // TESTING MANY TO MANY RELATIONSHIP...
    @GetMapping("/post-tags")
    public String getPostTags(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "/posts/test";
    }

@PostMapping("/post-tags/{id}")
    public String createNewTag(
            @PathVariable long id,
            @RequestParam String name) {
        Post p = postDao.getOne(id);
        tagDao.save(new Tag(name, Arrays.asList(p)));

        return "redirect:/post-tags";
}

// Relationships Exercise
    @GetMapping("/posts/create")
    public String formToCreatePost(Model model){
        model.addAttribute("post", new Post());
        return "createPost";
    }
//===== CREATE POST
    @PostMapping("/posts/create")
    public String createNewPost(
            @RequestParam String title,
            @RequestParam String body

    ){
//
        Post postToInsert = new Post(title, body);
        postToInsert.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Post post = postDao.save(postToInsert);
        // Send email message
        emailServices.prepareAndSend(post, "Post created", "An post has been created, with the id of " + post.getId());

        return "redirect:/posts/" + post.getId();
    }


}

//    @PostMapping("/ads/create")
//        public String create(@RequestParam String title, @RequestParam String description){
//            Ad adToInsert = new Ad(title, description);
//            adToInsert.setUser(userDao.getOne(1L));
//            Ad ad = adDao.save(adToInsert);
//            return "redirect:/ads/" + ad.getId();
//        }
