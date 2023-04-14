package com.github.dudiao.solon.demo.aot;

import com.github.dudiao.solon.demo.User;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeProcessor;
import org.noear.solon.core.AopContext;

/**
 * @author songyinyin
 * @since 2023/4/13 19:04
 */
@Slf4j
@Component
public class MyNativeProcessor implements RuntimeNativeProcessor {

  @Override
  public void process(AopContext context, RuntimeNativeMetadata nativeMetadata) {
    log.info("MyNativeProcessor process");
    nativeMetadata.registerSerialization(User.class);
  }
}
