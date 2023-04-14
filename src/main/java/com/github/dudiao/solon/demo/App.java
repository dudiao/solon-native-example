package com.github.dudiao.solon.demo;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Solon;
import org.noear.solon.SolonApp;
import org.noear.solon.annotation.SolonMain;
import org.noear.solon.core.util.LogUtil;
import org.noear.solon.core.wrap.ClassWrap;
import org.noear.solon.core.wrap.FieldWrap;
import org.noear.solon.logging.utils.LogUtilToSlf4j;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@SolonMain
public class App {

  public static void main(String[] args) {
    Solon.start(App.class, args, x -> {
      LogUtil.globalSet(new LogUtilToSlf4j());
    });
  }
}