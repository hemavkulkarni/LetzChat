package com.niit.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Forum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int forumid;
	private String forumtitle;
	private String forumcontent;
	private String forumUserName;
	private Date creationdatetime;
	private String category;

	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public String getForumtitle() {
		return forumtitle;
	}

	public void setForumtitle(String forumtitle) {
		this.forumtitle = forumtitle;
	}

	public String getForumcontent() {
		return forumcontent;
	}

	public void setForumcontent(String forumcontent) {
		this.forumcontent = forumcontent;
	}

	public String getForumUserName() {
		return forumUserName;
	}

	public void setForumUserName(String forumUserName) {
		this.forumUserName = forumUserName;
	}

	public Date getCreationdatetime() {
		return creationdatetime;
	}

	public void setCreationdatetime(Date creationdatetime) {
		this.creationdatetime = creationdatetime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
