package com.github.dudiao.solon.nativex.example.event;

import com.github.dudiao.solon.nativex.example.config.JsonTestConfig;
import com.github.dudiao.solon.nativex.example.mapper.UserMapper;
import com.github.dudiao.solon.nativex.example.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.solon.integration.MybatisAdapterDefault;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.event.AppLoadEndEvent;
import org.noear.solon.core.event.EventListener;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;

/**
 * @author songyinyin
 * @since 2023/4/5 10:34
 */
@Slf4j
@Component
public class AppStartEvent implements EventListener<AppLoadEndEvent> {

  @Inject()
  private JsonTestConfig config;
  @Db
  DbContext db;
  @Inject
  UserMapper userMapper;

  @Override
  public void onEvent(AppLoadEndEvent event) throws Throwable {
    log.info("app start end, config: {}", config);
    log.info("start init db ...");
    try {
      String ddl  = """
        CREATE TABLE my_user (
            user_id BIGINT PRIMARY KEY,
            head_img VARCHAR(255),
            nick_name VARCHAR(255),
            remark_name VARCHAR(255),
            name VARCHAR(255),
            wxid VARCHAR(255)
          );
        """;
      db.sql(ddl).execute();

      User user = new User();
      user.setUserId(1L);
      user.setWxid("wxid_123456");
      user.setName("dudiao");
      user.setHeadImg("https://xxx.com/1.jpg");
      user.setRemarkName("备注呀");
      userMapper.insert(user);

    } catch (Exception e) {
      log.error("init db error", e);
    }

  }

}
