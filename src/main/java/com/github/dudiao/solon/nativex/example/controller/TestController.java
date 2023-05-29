package com.github.dudiao.solon.nativex.example.controller;

import com.github.dudiao.solon.nativex.example.service.TestService;
import com.github.dudiao.solon.nativex.example.mapper.UserMapper;
import com.github.dudiao.solon.nativex.example.model.entity.User;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Param;
import org.noear.solon.annotation.Path;
import org.noear.solon.core.handle.ModelAndView;

/**
 * @author songyinyin
 * @since 2023/4/14 14:34
 */
@Controller
public class TestController {

  @Inject
  private TestService testService;
  @Inject
  UserMapper userMapper;

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


  @Mapping("/user/{id}")
  public User userById(@Path("id") Long id) {
    return userMapper.selectById(id);
  }
}
