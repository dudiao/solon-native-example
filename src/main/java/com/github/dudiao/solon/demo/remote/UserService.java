package com.github.dudiao.solon.demo.remote;

import com.github.dudiao.solon.demo.entity.User;

/**
 * @author songyinyin
 * @since 2023/4/15 16:11
 */
public interface UserService {

  User getById(long userId);
}
