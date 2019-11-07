package com.codeup.blog.blog.controllers;

import com.codeup.blog.blog.repositories.DogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DogController {
    private final DogRepository dogDao;

    public DogController(DogRepository dogDao) {
        this.dogDao = dogDao;
    }

    @GetMapping("/dogs")
    public String index(Model viewModel){

        viewModel.addAttribute("dogs", dogDao.findAll());
        return "dog";

    }


}
