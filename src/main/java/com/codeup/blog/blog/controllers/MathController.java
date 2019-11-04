package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @RequestMapping(path = "/add/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String addMethod(@PathVariable int num1, @PathVariable int num2){
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    @RequestMapping(path = "/subtract/{num1}/from/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtractMethod(@PathVariable int num1,@PathVariable int num2){
        return num1 + " - " + num2 + " = " + (num2 - num1 );
    }

    @RequestMapping(path = "/multiply/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiplyMethod(@PathVariable int num1,@PathVariable int num2){
        return num1 + " x " + num2 + " = " + (num1 * num2);
    }

    @RequestMapping(path = "/divide/{num1}/by/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String divideMethod(@PathVariable double num1,@PathVariable double num2){
        if (num1 == 0){
            return num1 + " can not be a zero.";
        }else if(num2 == 0){
            return num2 + " can not be a zero";
        }
        return num1 + " / " + num2 + " = " + (num1 / num2);
    }
}
