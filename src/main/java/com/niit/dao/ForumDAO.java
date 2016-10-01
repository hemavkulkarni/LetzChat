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

import com.niit.model.Forum;

@Repository
public class ForumDAO {
	
  Logger log = LoggerFactory.getLogger(ForumDAO.class);
	 
	@Autowired
	private SessionFactory sessionFactory;


	public ForumDAO(SessionFactory sessionFactory) {
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			log.error(" Unable to connect to db");
			e.printStackTrace();
		}
	}

	@Transactional
	public List<Forum> list() {
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) sessionFactory.getCurrentSession()
				.createCriteria(Forum.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	@Transactional
	public void saveOrUpdate(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
	}
	



	@Transactional
	public void delete(int id) {
		Forum forum = new Forum();
		forum.setPostId(id);
		sessionFactory.getCurrentSession().delete(forum);
	}

	@Transactional
	public Forum get(int id) {
		String hql = "from Forum where postid=" + "'"+ id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}
	
	


}

