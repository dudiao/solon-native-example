package com.github.dudiao.solon.nativex.example.dso.aot;

import com.github.dudiao.solon.nativex.example.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.core.AopContext;

/**
 * @author songyinyin
 * @since 2023/4/13 19:04
 */
@Slf4j
@Component
public class RuntimeNativeRegistrarImpl implements RuntimeNativeRegistrar {

  @Override
  public void register(AopContext context, RuntimeNativeMetadata nativeMetadata) {
    log.info("MyNativeProcessor process");
    nativeMetadata.registerSerialization(User.class);
  }
}
