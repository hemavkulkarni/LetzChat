package com.niit.model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
@Entity
@Table
public class Profile {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	int userid;

	@Column
	@NotEmpty(message = "Please enter your full name.")
	String fullname;

	
	@Column(unique=true,nullable=false)
	@NotEmpty(message = "Please enter your user name.")
	@Size(min = 5, max = 20, message = "Your name should be between 5 - 20 characters.")
	String uname;

	@Column
	@NotNull
	@NotEmpty(message = "Please enter your password.")
	@Length(min = 5, max = 20, message = "Password should be between 5 - 20 charactes")
	String password;

	@NotNull
	transient String rpassword;

	@Column
	@Pattern(regexp = ".+@.+\\..+", message = "Wrong email!")
	String emailid;

	@Column
	String phone;

	@Column
	String gender;
	@Column
	Date dob;

	private boolean enabled;

	@Column
	private String fpath;
	transient private MultipartFile file1;
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFpath() {
		return fpath;
	}

	public void setFpath(String fpath) {
		this.fpath = fpath;
	}

	public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRpassword() {
		return rpassword;
	}

	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getFilePath(String path1, String contextpath) {
		String fileName = null;
		if (!file1.isEmpty()) {
			try {

				fileName = file1.getOriginalFilename();
				byte[] bytes = file1.getBytes();
				String npath = path1 + "\\resources\\images\\" + fileName;

				BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(npath)));
				buffStream.write(bytes);
				buffStream.close();
				String dbfilename = contextpath + "/resources/images/" + fileName;

				this.setFpath(dbfilename);
				return dbfilename;
			} catch (Exception e) {
				return "You failed to upload " + fileName + ": " + e.getMessage();
			}
		} else {
			return "Unable to upload. File is empty.";
		}
	}
}