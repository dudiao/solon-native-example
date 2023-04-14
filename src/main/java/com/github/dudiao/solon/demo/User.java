package com.github.dudiao.solon.demo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author songyinyin
 * @since 2023/4/2 16:26
 */
@Data
public class User implements Serializable {

  private String head_img;

  private String nick_name;

  private String remark_name;

  private String user_name;

  private String wxid;

}
