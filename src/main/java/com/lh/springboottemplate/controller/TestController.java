package com.lh.springboottemplate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lh
 */
@RestController
@RequestMapping("/test")
public class TestController {
  @RequestMapping("/1")
  public String test() {
    return "liuhua";
  }
}

