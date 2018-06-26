package com.lmh.demo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lmh.demo.model.User;
import com.lmh.demo.service.UserService;

/**
 * Created by liumuhang on 2018/6/26.
 */
public class UserServiceTest extends BaseTest {

//  private static final String ORIGINAL_NAME = "Hello World";
//  private static final String CHINESE_NAME = "这个世界 你好啊";

  @Autowired
  private UserService userService;

  @Test
  public void testUserServiceQuery(){
    User user = userService.queryUserById(1);
    Assert.assertNotNull(user);
  }
}
