package com.reshma;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "loanusers")
@Entity
public class User {
	@Id
	int userid;
	String username;
	Date currentdate;
	String usertype;
	String password;
	String email;
	String recoveryemail;
	String mobile;

	public User() {
	}

	public User(int userid, String username, Date currentdate, String usertype, String password, String email,
			String recoveryemail, String mobile) {
		this.userid = userid;
		this.username = username;
		this.currentdate = currentdate;
		this.usertype = usertype;
		this.password = password;
		this.email = email;
		this.recoveryemail = recoveryemail;
		this.mobile = mobile;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(Date currentdate) {
		this.currentdate = currentdate;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRecoveryemail() {
		return recoveryemail;
	}

	public void setRecoveryemail(String recoveryemail) {
		this.recoveryemail = recoveryemail;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
