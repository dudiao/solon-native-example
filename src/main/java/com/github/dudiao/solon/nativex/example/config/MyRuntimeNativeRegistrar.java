package com.github.dudiao.solon.nativex.example.config;

import com.baomidou.mybatisplus.solon.plugins.pagination.Page;
import com.github.dudiao.solon.nativex.example.controller.TestController;
import org.noear.solon.annotation.Component;
import org.noear.solon.aot.RuntimeNativeMetadata;
import org.noear.solon.aot.RuntimeNativeRegistrar;
import org.noear.solon.core.AopContext;

/**
 * @author songyinyin
 * @since 2023/6/10 17:06
 */
@Component
public class MyRuntimeNativeRegistrar implements RuntimeNativeRegistrar {
  @Override
  public void register(AopContext context, RuntimeNativeMetadata metadata) {

    metadata.registerSerialization(Page.class);

    // test
    metadata.registerLambdaSerialization(TestController.class);
  }
}
