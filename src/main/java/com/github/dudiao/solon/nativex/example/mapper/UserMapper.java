package com.github.dudiao.solon.nativex.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.dudiao.solon.nativex.example.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author songyinyin
 * @since 2023/5/27 12:31
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
