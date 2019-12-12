/**
 * FileName: DataSourceInit2
 * Author:   huang.yj
 * Date:     2019/12/11 17:12
 * Description: 数据源初始化方式2
 */
package com.sample.test.dao.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

/**
 * 〈数据源初始化方式3〉
 *  通过读取properties配置文件注入Hikari的连接池配置中
 * @author huang.yj
 * @create 2019/12/11
 * @since 0.0.1
 */
@Configuration
public class DataSourceInit3 {

    @Bean
    public DataSource myDataSource3() {
        HikariConfig config = new HikariConfig("/hikari.properties");
        HikariDataSource ds = new HikariDataSource(config);
        return  ds;
    }

    /**
     *@描述  事务管理器，看需要是否添加注入
     *@参数  []
     *@返回值  org.springframework.jdbc.datasource.DataSourceTransactionManager
     *@创建人  huang.yj
     *@创建时间  2019/12/12
     */
    @Bean
    public DataSourceTransactionManager transactionManager3() {
        return new DataSourceTransactionManager(this.myDataSource3());
    }

}