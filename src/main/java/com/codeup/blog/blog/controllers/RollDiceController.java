package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDiceController {


@GetMapping("/roll-dice")
    public String roll(){
    return "roll-dice";
}

    @GetMapping("/roll-dice/{number}")
    public String roll(@PathVariable int number, Model model){
    model.addAttribute("number", number);

        Random random = new Random(); // Generates random number
        int randomNum = random.nextInt(6); // random number up to 6
        int[] numbers = {1,2,3,4,5,6};
        model.addAttribute("guess", numbers[randomNum]); // random num for guess

//            If user guesses the number correct
            if (number == numbers[randomNum]){
            model.addAttribute("correct_number", "correct_number");

            }



        System.out.println("random number "+ numbers[randomNum]);
        System.out.println(randomNum);
        return "roll-dice";
    }
}
