package com.github.dudiao.solon.nativex.example.controller;

import com.github.dudiao.solon.nativex.example.service.TestService;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Param;
import org.noear.solon.core.handle.ModelAndView;

/**
 * @author songyinyin
 * @since 2023/4/14 14:34
 */
@Controller
public class TestController {

  @Inject
  private TestService testService;

  @Mapping("/hello")
  public String hello(@Param(defaultValue = "world") String name) {
    return "Hello " + name;
  }

  @Mapping("/hello/tml")
  public ModelAndView helloTml(@Param(defaultValue = "world") String name) {
    return new ModelAndView("hello.ftl").put("name", name);
  }

  @Mapping("/cache/say")
  public String say(String msg) {
    return testService.say(msg);
  }
}
