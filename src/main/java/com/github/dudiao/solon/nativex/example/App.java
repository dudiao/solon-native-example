package com.github.dudiao.solon.nativex.example;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;

@Slf4j
@SolonMain
public class App {
  public static void main(String[] args) {
    Solon.start(App.class, args);
  }
}