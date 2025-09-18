package com.pack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Account 
{ @Id
	String email;
   String password;
   String username;
   
   public Account()
   {
	   
   }
   
   public Account(String em, String pwd, String uname)
   {
	   email=em;
	   password=pwd;
	   username=uname;
   }
   
   
   
   
   public void setEmail(String em)
   {
	   this.email=em;
	   
	   
   }
   public void setPassword(String pwd)
   {
	   
	   this.password=pwd;
	   
   }
   public void setUsername(String uname)
   {
	   
	   
	   username=uname;
   }
   
   public String getUsername()
   {
	   
	   return username;
   }
   public String getPassword()
   {
	   
	   return password;
   }
   public String getEmail()
   {
	   
	   return email;
   }
}
