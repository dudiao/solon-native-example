package com.github.dudiao.solon.nativex.example.service.impl;

import org.noear.solon.annotation.Component;
import org.noear.solon.data.annotation.Cache;

import com.github.dudiao.solon.nativex.example.service.TestService;

import cn.hutool.core.date.DateUtil;

/**
 * @author songyinyin
 * @since 2023/4/15 14:36
 */
@Component
public class TestServiceImpl implements TestService {

  @Override
  @Cache(key = "test::say::${msg}")
  public String say(String msg) {
    return "I want say: " + msg + ", now: " + DateUtil.now();
  }
}
