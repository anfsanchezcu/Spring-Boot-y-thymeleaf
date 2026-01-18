package com.anfsanchezcu.curso.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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
  // @Value("#{ '${config.listOfValues}'.split(',') }")
  // private List<String> valueList;
  @Value("#{${config.valuesMap}}")
  private Map<String, Object> valuesMap;
  @Value("#{${config.valuesMap}.product}")
  private String product;
  @Value("#{${config.valuesMap}.price}")
  private Long price;

  @Autowired
  private Environment env;

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
  public Map<String, Object> values() {

    Map<String, Object> valuesData = new HashMap<>();
    valuesData.put("username", userName);
    valuesData.put("message", message);
    valuesData.put("valuesMap", valuesMap);
    valuesData.put("product", product);
    valuesData.put("price", price);

    valuesData.put("messageEnv", env.getProperty("config.message"));
    valuesData.put("codeEnv", env.getProperty("config.code"));
    valuesData.put("codeIntEnv", Integer.valueOf(env.getProperty("config.code")));

    return valuesData;
  }
}
