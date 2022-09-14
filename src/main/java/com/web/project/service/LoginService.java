package com.web.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.project.entity.Login;
import com.web.project.repository.LoginRepository;
  
@Service
public class LoginService {
@Autowired
private LoginRepository repo;
  
  public Login login(String username, String password) {
  Login user = repo.findByUsernameAndPassword(username, password);
   return user;
  }
 
}