package com.lmh.demo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lmh.demo.mapper.testOne.UserMapper;
import com.lmh.demo.model.User;

import java.util.Date;

/**
 * Created by liumuhang on 2018/6/26.
 */
@Repository
public class UserRepository {

  @Autowired
  private UserMapper userMapper;

  public User queryUserById(long id) {
    return userMapper.queryById(id);
  }

  public User create(User user) {
    user.setCreateTime(new Date());
    userMapper.create(user);
    return user;
  }

  public int update(User user) {
    int row = userMapper.update(user);
    return row;
  }

  public int deleteById(long id) {
    int row = deleteById(id);
    return row;
  }
}
