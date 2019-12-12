/**
 * FileName: DataSourceInit2
 * Author:   huang.yj
 * Date:     2019/12/11 17:12
 * Description: 数据源初始化方式2
 */
package com.sample.test.dao.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

/**
 * 〈数据源初始化方式2〉
 *  通过@Value的方式注入Hikari的连接池配置中
 * @author huang.yj
 * @create 2019/12/11
 * @since 0.0.1
 */
@Configuration
public class DataSourceInit2 {

    @Value("${spring.datasource.ds1.pool-name}")
    private String poolName;

    @Value("${spring.datasource.ds1.jdbc-url}")
    private String url;

    @Value("${spring.datasource.ds1.username}")
    private String user;

    @Value("${spring.datasource.ds1.password}")
    private String password;

    @Value("${spring.datasource.ds1.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.ds1.connection-timeout}")
    private Long connectionTimeout;

    @Value("${spring.datasource.ds1.idle-timeout}")
    private Long idleTimeout;

    @Value("${spring.datasource.ds1.max-lifetime}")
    private Long maxLifetime;

    @Value("${spring.datasource.ds1.maximum-pool-size}")
    private Integer maximumPoolSize;

    @Value("${spring.datasource.ds1.minimum-idle}")
    private Integer minimumIdle;

    @Value("${spring.datasource.ds1.auto-commit}")
    private Boolean autoCommit;

    @Value("${spring.datasource.ds1.connection-test-query}")
    private String connectionTestQuery;

    @Value("${spring.datasource.ds1.cachePrepStmts}")
    private String cachePrepStmts;

    @Value("${spring.datasource.ds1.prepStmtCacheSize}")
    private String prepStmtCacheSize;

    @Value("${spring.datasource.ds1.prepStmtCacheSqlLimit}")
    private String prepStmtCacheSqlLimit;

    @Bean
    public DataSource myDataSource2() {
        HikariConfig config = new HikariConfig();
        config.setPoolName(poolName);
        config.setJdbcUrl(url); //数据源
        config.setUsername(user); //用户名
        config.setPassword(password); //密码
        config.setDriverClassName(driverClassName);
        config.setConnectionTimeout(connectionTimeout);
        config.setIdleTimeout(idleTimeout);
        config.setMaxLifetime(maxLifetime);
        config.setMaximumPoolSize(maximumPoolSize);
        config.setMinimumIdle(minimumIdle);
        config.setAutoCommit(autoCommit);
        config.setConnectionTestQuery(connectionTestQuery);
        config.addDataSourceProperty("cachePrepStmts", cachePrepStmts); //是否自定义配置，为true时下面两个参数才生效
        config.addDataSourceProperty("prepStmtCacheSize", prepStmtCacheSize); //连接池大小默认25，官方推荐250-500
        config.addDataSourceProperty("prepStmtCacheSqlLimit", prepStmtCacheSqlLimit); //单条语句最大长度默认256，官方推荐2048

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
    public DataSourceTransactionManager transactionManager2() {
        return new DataSourceTransactionManager(this.myDataSource2());
    }

}