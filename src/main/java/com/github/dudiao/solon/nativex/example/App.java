package com.github.dudiao.solon.nativex.example;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;
import org.noear.solon.core.util.LogUtil;
import org.noear.solon.logging.utils.LogUtilToSlf4j;

@Slf4j
@SolonMain
public class App {
  public static void main(String[] args) {
    Solon.start(App.class, args);
  }
}