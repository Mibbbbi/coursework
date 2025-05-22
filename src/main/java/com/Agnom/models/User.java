package com.Agnom.models;

public class User {
private String username;
private String role; 
private String password;
private int id;
private long phnno;
private String email;
private String firstname;
private String lastname;


//For Recieveing values from database
 public User( String username,String password, long phoneno,String email,String firstname,String lastname) {
	this.username=username;
	this.password=password;
	this.phnno =phoneno;
	this.email=email;
	this.firstname =firstname;
	this.lastname = lastname;
	
}
//setting and getter
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id=id;
}

public long getPhnno() {
	return phnno;
}
public void setPhnno(long phnno) {
	this.phnno = phnno;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
}
