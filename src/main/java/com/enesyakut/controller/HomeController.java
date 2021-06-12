package com.enesyakut.controller;

import com.enesyakut.model.Blog;
import com.enesyakut.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private final BlogService blogService;

    public HomeController(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping(value = { "/" , "/home" }, method = RequestMethod.GET)
    public ModelAndView getHome(ModelAndView modelAndView, Model model){
        List<Blog> blogList = blogService.getAllPosts();
        model.addAttribute("blog", blogList);
        model.addAttribute("pageType","/WEB-INF/jsp/home.jsp");
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
