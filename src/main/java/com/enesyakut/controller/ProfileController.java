package com.enesyakut.controller;

import com.enesyakut.model.Blog;
import com.enesyakut.model.User;
import com.enesyakut.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ProfileController {
    @Autowired
    private final BlogService blogService;

    public ProfileController(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping(value = {"/profile"} ,method = RequestMethod.GET)
    public ModelAndView showHome(ModelAndView modelAndView , Model model , HttpSession session){
        User user = (User) session.getAttribute("userSession");
        List<Blog> blogList = blogService.getPostByUser(user.getId());
        model.addAttribute("blog", blogList);
        model.addAttribute("user", user);
        model.addAttribute("pageType","/WEB-INF/jsp/profile.jsp");
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(User user,ModelAndView modelAndView, HttpSession httpSession, RedirectAttributes redirectAttributes){
        httpSession.invalidate();
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}
