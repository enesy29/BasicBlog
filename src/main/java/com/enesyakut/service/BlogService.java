package com.enesyakut.service;

import com.enesyakut.model.Blog;
import com.enesyakut.model.User;
import com.enesyakut.repository.BlogRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private final BlogRepository blogRepository;
    private SessionFactory sessionFactory;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog addPost(Blog blog , User user){
        blog.setCreate_date(LocalDate.now());
        blog.setUser(user);
        Blog saveBlog = blogRepository.save(blog);
        return saveBlog;
    }

    public void deletePost(Long id){
        blogRepository.deleteById(id);
    }

    public Blog updatePost(Blog blog , User user) {
        Blog updatePost = blogRepository.save(blog);
        blog.setTitle(updatePost.getTitle());
        blog.setContent(updatePost.getContent());
        blog.setCreate_date(LocalDate.now());
        blog.setUser(user);
        blog = blogRepository.save(blog);
        return updatePost;
    }

    public Blog findPost(Long id){
        Blog blog = blogRepository.findById(id).get();
        return blog;
    }

    public List<Blog> getAllPosts(){
        List<Blog> blogList = blogRepository.findAll();
        return blogList;
    }

    public List<Blog> getPostByUser(Long id){
        List<Blog> blogList = blogRepository.getBlogsByUser_id(id);
        return blogList;
    }

}
