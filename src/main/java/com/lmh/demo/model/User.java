package com.lmh.demo.model;

import java.util.Date;

/**
 * Created by liumuhang on 2018/6/26.
 */
public class User {
  private Long id;

  private String userName;

  private String cellPhone;

  private Date createTime;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(final String userName) {
    this.userName = userName;
  }

  public String getCellPhone() {
    return cellPhone;
  }

  public void setCellPhone(final String cellPhone) {
    this.cellPhone = cellPhone;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(final Date createTime) {
    this.createTime = createTime;
  }
}
