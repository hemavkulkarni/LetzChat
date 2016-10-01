package com.niit.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class JobOpportunity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	   
	private int id;	
	@Column
	private String job_type;
	@Column 
	private String company_name;
	@Column
	private String desc;
	@Column
	private String location;
	@Column
	private String salary;
	@Column
	private float workinghour;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJob_type() {
		return job_type;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public float getWorkinghour() {
		return workinghour;
	}
	public void setWorkinghour(float workinghour) {
		this.workinghour = workinghour;
	}
	

}
