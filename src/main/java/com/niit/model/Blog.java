package com.niit.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	   
	private int blogid;
	@Column
	private String blogtitle;
	@Column
	private String blogdesc;
	@Column
	private String status;
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getBlogtitle() {
		return blogtitle;
	}
	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}
	public String getBlogdesc() {
		return blogdesc;
	}
	public void setBlogdesc(String blogdesc) {
		this.blogdesc = blogdesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
