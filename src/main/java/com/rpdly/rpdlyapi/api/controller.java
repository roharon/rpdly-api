package com.rpdly.rpdlyapi.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

  @PostMapping("/callback")
  public @ResponseBody String test(@RequestBody String content) {
    return content;
  }

}
