package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

@Service("blogService")
public class BlogService{
    
	@Autowired
	private BlogDAO blogDAO;
     
    
 
    public List<Blog> findAllBlogs() {
        
    	List<Blog> blogs=blogDAO.list();
    	return blogs;
    }
     
    public Blog findById(int id) {
        
    	return blogDAO.get(id);
    }
     
    
     
    public void saveBlog(Blog blog) {
        
    	blogDAO.saveOrUpdate(blog);
    }
 
    public void updateBlog(Blog blog) {
        
    	blogDAO.saveOrUpdate(blog);
    }
 
    public void deleteBlogById(int id) {
         
        blogDAO.delete(id);
    }
 
      

 
}
