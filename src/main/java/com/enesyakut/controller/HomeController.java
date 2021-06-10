package com.enesyakut.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    @RequestMapping(value = { "/" , "/home" }, method = RequestMethod.GET)
    public ModelAndView getHome(ModelAndView modelAndView , Model model){
        model.addAttribute("pageType","/WEB-INF/jsp/home.jsp");
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
