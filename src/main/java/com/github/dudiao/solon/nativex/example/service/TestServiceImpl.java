package com.github.dudiao.solon.nativex.example.service;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.ProxyComponent;
import org.noear.solon.data.annotation.Cache;

/**
 * @author songyinyin
 * @since 2023/4/15 14:36
 */
@Slf4j
@ProxyComponent
public class TestServiceImpl implements TestService {

  @Override
  @Cache(key = "test::say::${msg}")
  public String say(String msg) {
    return "I want say: " + msg + ", now: " + DateUtil.now();
  }
}
