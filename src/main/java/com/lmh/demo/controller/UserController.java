package com.lmh.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmh.demo.model.User;
import com.lmh.demo.service.UserService;

/**
 * Created by liumuhang on 2018/6/24.
 */
@RestController
@RequestMapping("/user")
public class UserController {

  private final static Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  @GetMapping(value = "/hello")
  public String hello(){
    return "hello world";
  }

  @GetMapping(value = "/query/{id}")
  public User queryUserById(@PathVariable long id) {
    return userService.queryUserById(id);
  }

  @PostMapping(value = "/create")
  public User create(User user){
    return userService.create(user);
  }


}
