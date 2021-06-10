package com.enesyakut.controller;

import com.enesyakut.model.Blog;
import com.enesyakut.model.User;
import com.enesyakut.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping(value ={"/blog/{id}"} , method = RequestMethod.GET)
    public ModelAndView getPost(@PathVariable("id") Long id , ModelAndView modelAndView , Model model){
        Blog blog = blogService.findPost(id);
        model.addAttribute("blog",blog);
        model.addAttribute("pageType","/WEB-INF/jsp/blog.jsp");
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @RequestMapping(value ={"/blog/addPost"} , method = RequestMethod.GET)
    public ModelAndView getAddPost(Long blogId , ModelAndView modelAndView , Model model , HttpSession session){
        User user = (User) session.getAttribute("userSession");
        Blog blog = new Blog();
        model.addAttribute("blog",blog);
        model.addAttribute("pageType","/WEB-INF/jsp/addPost.jsp");
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @RequestMapping(value ={"/blog/addPost"} , method = RequestMethod.POST)
    public ModelAndView AddPost(@Valid @ModelAttribute("product")Blog blog, BindingResult result , Model model , ModelAndView modelAndView , HttpSession session){
        User user = (User) session.getAttribute("userSession");
        if (result.hasErrors()){
            model.addAttribute("pageType","/WEB-INF/jsp/addPost.jsp");
            modelAndView.setViewName("main");
            return modelAndView;
        }
        blogService.addPost(blog , user);
        LocalDate today = LocalDate.now();
        modelAndView.setViewName("redirect:/profile");
        return modelAndView;
    }

    @RequestMapping(value = "/blog/editPost/{id}", method = RequestMethod.GET)
    public ModelAndView ShowEditPost(@PathVariable("id") Long id , Model model , ModelAndView modelAndView , HttpSession session){
        User user = (User) session.getAttribute("userSession");
        Blog blog = blogService.findPost(id);
        model.addAttribute("blog",blog);
        model.addAttribute("pageType","/WEB-INF/jsp/editPost.jsp");
        modelAndView.setViewName("main");
        return modelAndView;
    }
    @RequestMapping(value = "/blog/editPost",method = RequestMethod.POST)
    public ModelAndView editPost(@Valid @ModelAttribute("blog")Blog blog,BindingResult result,Model model , ModelAndView modelAndView , HttpSession session){
        User user = (User) session.getAttribute("userSession");
        if (result.hasErrors()){
            model.addAttribute("pageType","/WEB-INF/jsp/editPost.jsp");
            modelAndView.setViewName("main");
            return modelAndView;
        }
        blogService.updatePost(blog , user);
        LocalDate today = LocalDate.now();
        modelAndView.setViewName("redirect:/profile");
        return modelAndView;
    }
    @RequestMapping("/blog/deletePost/{id}")
    public ModelAndView deletePost(@PathVariable Long id,ModelAndView modelAndView){
        blogService.deletePost(id);
        modelAndView.setViewName("redirect:/profile");
        return modelAndView;
    }

}
