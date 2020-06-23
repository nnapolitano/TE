package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    public HomeController() {
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String displayHomePage() {
        return "main/index";
    }

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String displayIndexPage() {
        return "main/index";
    }

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String displayErrorPage() {
        return "main/error";
    }

}



