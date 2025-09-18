package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.pack.entity.Info;
import com.pack.repo.InfoRepo;

@Service
public class InfoService
{ @Autowired
  private InfoRepo infoRepo;
  public Info getInfo(int id)
  {
	  return infoRepo.findById(id).get();
	 // return infoRepo.findOne(id);
  }
  public Info findUsername(String username)
  {
	  return infoRepo.findByUsername(username);
  }
  public void setInfo(Info in)
  {
	  
	  infoRepo.save(in);
  }
}
