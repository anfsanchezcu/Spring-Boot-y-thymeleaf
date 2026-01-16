package com.anfsanchezcu.curso.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anfsanchezcu.curso.webapp.springboot_web.models.User;
import com.anfsanchezcu.curso.webapp.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

  @GetMapping(path = "list")
  public List<User> list(){
    User u1 = new User("Andres","Sanchez");
    User u2 = new User("Niko","Gonzales");
    User u3 = new User("Dany","Rengifo");

    List<User> listUsers = Arrays.asList(u1,u2,u3);
    
    return listUsers;
  }
  
  @GetMapping(path = "/detailsRestDto")
  public UserDto detailsDto() {

    User user = new User("Andres", "Sanchez");

    UserDto userDto = new UserDto();
    userDto.setUser(user.getName());
    userDto.setUser(user.getName());
    userDto.setLastName(user.getLastName());
    userDto.setTitle("Hola Mundo Spring Boot");

    return userDto;
  }

  @GetMapping(path = "/detailsRest")
  public Map<String, Object> details() {
    User user = new User("Andres", "Sanchez");
    Map<String, Object> body = new HashMap<>();

    body.put("title", "Hola Mundo Spring Boot");
    body.put("user", user);

    return body;
  }
}
