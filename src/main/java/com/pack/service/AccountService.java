package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.entity.Account;

import com.pack.repo.AccountRepo;


@Service
public class AccountService {
	@Autowired
	  private AccountRepo accRepo;
	  public Account getAcc(String email)
	  {
		 
		  //return accRepo.findOne(email);
		  return  accRepo.findById(email).get();
	  }
	  public void setAcc(Account acc)
	  {
		   accRepo.save(acc);
		  
		  
	  }
	  public Account findUsername(String name)
	  {
		  
		  return accRepo.findByUsername(name);
	  }
	  public Account checkLogin(String uname, String pwd)
	  {
		  
		return  accRepo.findByUsernameAndPassword(uname, pwd);
		  
	  }
}
