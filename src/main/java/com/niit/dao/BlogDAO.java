package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Blog;

@Repository
public class BlogDAO {
	
  Logger log = LoggerFactory.getLogger(BlogDAO.class);
	 
	@Autowired
	private SessionFactory sessionFactory;


	public BlogDAO(SessionFactory sessionFactory) {
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			log.error(" Unable to connect to db");
			e.printStackTrace();
		}
	}

	@Transactional
	public List<Blog> list() {
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) sessionFactory.getCurrentSession()
				.createCriteria(Blog.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	@Transactional
	public void saveOrUpdate(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}
	



	@Transactional
	public void delete(int id) {
		Blog blog = new Blog();
		blog.setBlogId(id);
		sessionFactory.getCurrentSession().delete(blog);
	}

	@Transactional
	public Blog get(int id) {
		String hql = "from Blog where blogid=" + "'"+ id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}
	
	


}

