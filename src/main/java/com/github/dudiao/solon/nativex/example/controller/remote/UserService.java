package com.github.dudiao.solon.nativex.example.controller.remote;

import com.github.dudiao.solon.nativex.example.model.entity.Order;
import com.github.dudiao.solon.nativex.example.model.entity.User;

/**
 * @author songyinyin
 * @since 2023/4/15 16:11
 */
public interface UserService {

  User getById(long userId);
  long addOrder(Order order);
}
