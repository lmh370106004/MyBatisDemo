package com.lmh.demo.service;

import com.lmh.demo.model.User;

/**
 * Created by liumuhang on 2018/6/24.
 */
public interface UserService {

  User queryUserById(long id);

  User create(User user);

  int update(User user);

  int deleteById(long id);
}
