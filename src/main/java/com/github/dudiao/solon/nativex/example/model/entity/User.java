package com.github.dudiao.solon.nativex.example.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author songyinyin
 * @since 2023/4/2 16:26
 */
@Data
@TableName("my_user")
public class User implements Serializable {

  private Long userId;

  private String headImg;

  private String nickName;

  private String remarkName;

  private String name;

  private String wxid;

}
