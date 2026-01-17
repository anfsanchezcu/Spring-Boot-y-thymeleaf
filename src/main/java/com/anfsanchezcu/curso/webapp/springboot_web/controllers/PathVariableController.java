package com.anfsanchezcu.curso.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anfsanchezcu.curso.webapp.springboot_web.models.User;
import com.anfsanchezcu.curso.webapp.springboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

  @Value("${config.username}")
  private String userName;
  @Value("${config.message}") 
  private String message;
  
  @GetMapping("/baz/{message}")
  public ParamDto baz(@PathVariable(required = false) String message) {

    ParamDto param = new ParamDto(message);
    return param;

  }

  @GetMapping("/mix/{product}/{id}")
  public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {

    Map<String, Object> json = new HashMap<>();
    json.put("producto", product);
    json.put("id", id);

    return json;
  }

  @PostMapping("/create")
  public User create(@RequestBody User user) {
    user.setName(user.getName().toUpperCase());
    return user;
  }

  @GetMapping("/values")
  public Map<String, Object> values(){
    
    Map<String, Object> map = new HashMap<>();
    map.put("username",userName);
    map.put("message",message);

    return map; 
  }
}
