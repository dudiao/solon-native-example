package com.github.dudiao.solon.nativex.example.controller.remote;

import com.github.dudiao.solon.nativex.example.model.entity.Order;
import com.github.dudiao.solon.nativex.example.model.entity.User;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Remoting;

/**
 * @author songyinyin
 * @since 2023/4/15 16:12
 */
@Remoting
@Mapping("/rpc/v1/user")
public class UserServiceImpl implements UserService{
  @Override
  public User getById(long userId) {
    User user = new User();
    user.setWxid(String.valueOf(userId));
    user.setUser_name("dudiao");
    return user;
  }

  @Override
  public long addOrder(Order order) {
    return order.getOrderId();
  }
}
