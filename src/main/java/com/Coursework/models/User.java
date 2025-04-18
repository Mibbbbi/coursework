package com.Coursework.models;

public class User {
private String username;
private String role; 
private String password;
private int id;
private int phnno;
private String email;
private String firstname;
private String lastname;



 public User(int id , String username,String password,String role , int phoneno,String email,String firstname,String lastname) {
    this.id =id;
    this.username=username;
    this.password=password;
    this.role = role;	
    this.phnno =phoneno;
    this.email=email;
    this.firstname =firstname;
    this.lastname = lastname;
    
            
    
 }
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
    this.id = id;
 }
 public int getPhnno() {
    return phnno;
 }
 public void setPhnno(int phnno) {
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