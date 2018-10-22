package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ERS_USERS")
public class User {
	@Id
	@Column(name = "U_ID")
	int id;

	@Column(name = "U_USERNAME")
	String uName;

	@Column(name = "U_PASSWORD")
	String password;

	@Column(name = "U_FIRSTNAME")
	String fName;

	@Column(name = "U_LASTNAME")
	String lName;

	@Column(name = "U_EMAIL")
	String email;

	@Column(name = "UR_ID")
	int urId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUrId() {
		return urId;
	}

	public void setUrId(int urId) {
		this.urId = urId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uName=" + uName + ", password=" + password + ", fName=" + fName + ", lName="
				+ lName + ", email=" + email + ", urId=" + urId + "]";
	}

}