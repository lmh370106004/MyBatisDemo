package com.lmh.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmh.demo.model.User;
import com.lmh.demo.repo.UserRepository;
import com.lmh.demo.service.UserService;

/**
 * Created by liumuhang on 2018/6/26.
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User queryUserById(final long id) {
    return userRepository.queryUserById(id);
  }

  @Override
  public User create(final User user) {
    return userRepository.create(user);
  }

  @Override
  public int update(final User user) {
    int row = userRepository.update(user);
    return row;
  }

  @Override
  public int deleteById(final long id) {
    return userRepository.deleteById(id);
  }
}
