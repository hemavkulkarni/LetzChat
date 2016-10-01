package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ForumDAO;
import com.niit.model.Forum;

@Service("forumService")
public class ForumService{
    
	@Autowired
	private ForumDAO forumDAO;
     
    
 
    public List<Forum> findAllForums() {
        
    	List<Forum> forums=forumDAO.list();
    	return forums;
    }
     
    public Forum findById(int id) {
        
    	return forumDAO.get(id);
    }
     
    
     
    public void saveForum(Forum forum) {
        
    	forumDAO.saveOrUpdate(forum);
    }
 
    public void updateForum(Forum forum) {
        
    	forumDAO.saveOrUpdate(forum);
    }
 
    public void deleteForumById(int id) {
         
        forumDAO.delete(id);
    }
 
 
}
