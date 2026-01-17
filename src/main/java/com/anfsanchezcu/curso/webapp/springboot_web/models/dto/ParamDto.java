package com.anfsanchezcu.curso.webapp.springboot_web.models.dto;

public class ParamDto {
  private String message;

  public ParamDto(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
