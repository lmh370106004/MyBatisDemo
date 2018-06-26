package com.lmh.demo.mapper.testOne;

import org.apache.ibatis.annotations.Param;

import com.lmh.demo.model.User;

/**
 * Created by liumuhang on 2018/6/26.
 */
public interface UserMapper {

  User queryById(@Param("id") long id);

  int create(User user);

  int update(User user);

  int deleteById(@Param("id") long id);
}
