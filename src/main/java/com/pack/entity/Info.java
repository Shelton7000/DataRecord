package com.pack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Info 
{@Id
@GeneratedValue(strategy = GenerationType.AUTO)
 private int id;
 private String fname;
 private String lname;
 private String username;
 private String password;
 //int strength;
 //int speed;
 public Info()
 {
	 
 }
 public Info(int id,String fname, String name,String un)
 {
	 super();
	 this.id=id;
	 this.fname=fname;
	 this.lname=lname;
	 username=un;
	 
 }
 
 public int getId()
 {
	 return id;
	 
 }
 
 public String getFname()
 {
   return fname;
 }
 public String getLname()
 {
   return lname;
 }
 public String getUsername()
 {
	 return username;
 }
 public void setUsername(String un)
 {
	 username=un;
 }
 public void setId(int id)
 {
	 this.id=id;
	 
 }
 public void setFname(String fname)
 {
	 this.fname=fname;
	 
 }

 
 public void setLname(String lname)
 {
	 this.lname=lname;
	 
 }
 public String getPassword() {
	return password;
 }
 public void setPassword(String password) {
	this.password = password;
 }

}
