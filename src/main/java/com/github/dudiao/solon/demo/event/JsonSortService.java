package com.github.dudiao.solon.demo.event;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.event.AppLoadEndEvent;
import org.noear.solon.core.event.EventListener;

/**
 * @author songyinyin
 * @since 2023/4/5 10:34
 */
@Slf4j
@Component
public class JsonSortService implements EventListener<AppLoadEndEvent> {

  @Inject()
  private JsonSortConfig config;

  @Override
  public void onEvent(AppLoadEndEvent event) {
    log.info("app start end, config: {}", config);
  }

}
