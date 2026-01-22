package com.anfsanchezcu.curso.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.anfsanchezcu.curso.webapp.springboot_web.models.User;

@Controller
public class UserController {

  @GetMapping("/details")
  public String details(Model model) {

    User user = new User("Andres", "Sanchez");

    model.addAttribute("title", "Hola Mundo Spring Boot");
    model.addAttribute("user", user);

    return "details";
  }

  @GetMapping("/list")
  public String List(ModelMap model) {
    model.addAttribute("title", "lista de usuarios");
    return "list";
  }

  @ModelAttribute("users") 
  public List<User> userModel(){
    User u1 = new User("Andres","Sanchez");
    User u2 = new User("Niko","Gonzales");
    User u3 = new User("Dany","Rengifo");

    List<User> listUsers = Arrays.asList(u1,u2,u3);

    return listUsers;
  }
}
