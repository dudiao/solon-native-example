package com.github.dudiao.solon.nativex.example.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.solon.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.solon.plugins.inner.PaginationInnerInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.solon.annotation.Db;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

import javax.sql.DataSource;

/**
 * @author songyinyin
 * @since 2023/5/27 11:30
 */
@Configuration
public class MybatisConfig {

  /**
   * 配置数据源
   */
  @Bean(name = "db1", typed = true)
  DataSource datasource(@Inject("${datasource}") HikariDataSource ds) {
    return ds;
  }

  @Bean
  public void db1_cfg(@Db("db1") MybatisConfiguration cfg,
                      @Db("db1") GlobalConfig globalConfig) {
    MybatisPlusInterceptor plusInterceptor = new MybatisPlusInterceptor();
    plusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

    cfg.setCacheEnabled(false);
    cfg.addInterceptor(plusInterceptor);
  }
}
