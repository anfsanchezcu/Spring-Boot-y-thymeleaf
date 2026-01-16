package com.anfsanchezcu.curso.webapp.springboot_web.models.dto;

import com.anfsanchezcu.curso.webapp.springboot_web.models.User;

public class UserDto {

  private String title;
  private String user;
  private String lastName;

  
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getUser() {
    return user;
  }
  public void setUser(String user) {
    this.user = user;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  
}
