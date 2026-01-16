package com.anfsanchezcu.curso.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anfsanchezcu.curso.webapp.springboot_web.models.dto.ParamDto;
import com.anfsanchezcu.curso.webapp.springboot_web.models.dto.ParamMixDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/params")
public class RqParamsController {

  @GetMapping("/foo")
  public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola default", name = "mensaje") String message) {

    ParamDto paramDto = new ParamDto();
    paramDto.setMessage(message);

    return paramDto;
  }

  @GetMapping("/bar")
  public ParamMixDto bar(@RequestParam() String text, @RequestParam(required = false) Integer code) {

    ParamMixDto paramDto = new ParamMixDto();
    paramDto.setMessage(text);
    paramDto.setCode(code);

    return paramDto;
  }

}
