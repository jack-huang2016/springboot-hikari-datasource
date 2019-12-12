/**
 * FileName: DataSourceInit2
 * Author:   huang.yj
 * Date:     2019/12/11 17:12
 * Description: 数据源初始化方式2
 */
package com.sample.test.dao.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

/**
 * 〈数据源初始化方式4〉
 *  通过Environment类注入Hikari的连接池配置中
 * @author huang.yj
 * @create 2019/12/11
 * @since 0.0.1
 */
@Configuration
public class DataSourceInit4 {

    @Autowired
    private Environment env;

    @Bean
    public DataSource myDataSource4() {
        HikariConfig config = new HikariConfig();
        config.setPoolName(env.getProperty("spring.datasource.ds1.pool-name"));
        config.setJdbcUrl(env.getProperty("spring.datasource.ds1.jdbc-url"));
        config.setUsername(env.getProperty("spring.datasource.ds1.username"));
        config.setPassword(env.getProperty("spring.datasource.ds1.password"));
        config.setDriverClassName(env.getProperty("spring.datasource.ds1.driver-class-name"));
        config.setConnectionTimeout(env.getProperty("spring.datasource.ds1.connection-timeout", Long.class));
        config.setIdleTimeout(env.getProperty("spring.datasource.ds1.idle-timeout", Long.class));
        config.setMaxLifetime(env.getProperty("spring.datasource.ds1.max-lifetime", Long.class));
        config.setMaximumPoolSize(env.getProperty("spring.datasource.ds1.maximum-pool-size", Integer.class));
        config.setMinimumIdle(env.getProperty("spring.datasource.ds1.minimum-idle", Integer.class));
        config.setAutoCommit(env.getProperty("spring.datasource.ds1.auto-commit", Boolean.class));
        config.setConnectionTestQuery(env.getProperty("spring.datasource.ds1.connection-test-query"));
        config.addDataSourceProperty("cachePrepStmts", env.getProperty("spring.datasource.ds1.cachePrepStmts")); //是否自定义配置，为true时下面两个参数才生效
        config.addDataSourceProperty("prepStmtCacheSize", env.getProperty("spring.datasource.ds1.prepStmtCacheSize")); //连接池大小默认25，官方推荐250-500
        config.addDataSourceProperty("prepStmtCacheSqlLimit", env.getProperty("spring.datasource.ds1.prepStmtCacheSqlLimit")); //单条语句最大长度默认256，官方推荐2048

        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }

    /**
     *@描述  事务管理器，看需要是否添加注入
     *@参数  []
     *@返回值  org.springframework.jdbc.datasource.DataSourceTransactionManager
     *@创建人  huang.yj
     *@创建时间  2019/12/12
     */
    @Bean
    public DataSourceTransactionManager transactionManager4() {
        return new DataSourceTransactionManager(this.myDataSource4());
    }
}