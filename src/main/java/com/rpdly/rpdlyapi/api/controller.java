package com.rpdly.rpdlyapi.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

  @GetMapping("/{content}")
  public @ResponseBody String test(@PathVariable String content) {
    return content;
  }

}
