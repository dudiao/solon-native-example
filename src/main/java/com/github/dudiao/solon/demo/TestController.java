package com.github.dudiao.solon.demo;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * @author songyinyin
 * @since 2023/4/14 14:34
 */
@Controller
public class TestController {

  @Mapping("/hello")
  public String hello(String msg) {
    return "Hello world! " + msg;
  }
}
