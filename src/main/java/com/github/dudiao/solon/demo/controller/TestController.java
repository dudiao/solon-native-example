package com.github.dudiao.solon.demo.controller;

import com.github.dudiao.solon.demo.service.TestService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

/**
 * @author songyinyin
 * @since 2023/4/14 14:34
 */
@Controller
public class TestController {

  @Inject
  private TestService testService;

  @Mapping("/hello")
  public String hello(String msg) {
    return "Hello world! " + msg;
  }

  @Mapping("/cache/say")
  public String say(String msg) {
    return testService.say(msg);
  }

}
