package com.pack.repo;

import org.springframework.data.repository.CrudRepository;

import com.pack.entity.Account;


public interface AccountRepo extends CrudRepository<Account, String>
{
 public Account findByUsername(String name);
 public Account findByUsernameAndPassword(String uname, String pwd);



}
