package com.github.dudiao.solon.nativex.example.mapper;

import com.github.dudiao.solon.nativex.example.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author songyinyin
 * @since 2023/5/27 12:31
 */
@Mapper
public interface UserMapper {

  int insert(User user);

  User selectById(Long userId);
}
