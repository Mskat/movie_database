package com.moviedatabase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

    @RequestMapping("/list")
    public String movieList() {
        return "list";
    }

}
