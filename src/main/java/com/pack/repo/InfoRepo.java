package com.pack.repo;

import org.springframework.data.repository.CrudRepository;

import com.pack.entity.*;
public interface InfoRepo extends CrudRepository<Info, Integer> 
{
 public Info findByUsername(String title);
}
