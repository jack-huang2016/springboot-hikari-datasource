/**
 * FileName: DataSourceTest2DaoImpl
 * Author:   huang.yj
 * Date:     2019/12/12 9:44
 * Description:
 */
package com.sample.test.dao;

import com.sample.test.common.MgrParamScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author huang.yj
 * @create 2019/12/12
 * @since 0.0.1
 */
@Slf4j
@Repository
public class DataSourceTest2DaoImpl implements DataSourceTest2Dao{
    @Autowired
    @Qualifier(value = "myDataSource2")
    private DataSource dataSource2;

    @Resource(name = "myDataSource3")
    private DataSource dataSource3;

    @Resource(name = "myDataSource4")
    private DataSource dataSource4;

    @Override
    public List<MgrParamScope> selectAll2() throws Exception{
        try(Connection conn = dataSource2.getConnection()) {
            List<MgrParamScope> list = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement("select * from u_db_pt.mgr_param_scope");
            ResultSet rs = statement.executeQuery();
            MgrParamScope bean;
            while (rs.next()) {
                bean = new MgrParamScope();
                bean.setApiId(rs.getInt("api_id"));
                bean.setParamKey(rs.getString("token"));
                bean.setToken(rs.getString("param_key"));
                bean.setValue(rs.getString("value"));
                list.add(bean);
            }

            return list;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<MgrParamScope> selectAll3() throws Exception {
        try(Connection conn = dataSource3.getConnection()) {
            List<MgrParamScope> list = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement("select * from u_db_pt.mgr_param_scope");
            ResultSet rs = statement.executeQuery();
            MgrParamScope bean;
            while (rs.next()) {
                bean = new MgrParamScope();
                bean.setApiId(rs.getInt("api_id"));
                bean.setParamKey(rs.getString("token"));
                bean.setToken(rs.getString("param_key"));
                bean.setValue(rs.getString("value"));
                list.add(bean);
            }

            return list;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<MgrParamScope> selectAll4() throws Exception {
        try(Connection conn = dataSource4.getConnection()) {
            List<MgrParamScope> list = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement("select * from u_db_pt.mgr_param_scope");
            ResultSet rs = statement.executeQuery();
            MgrParamScope bean;
            while (rs.next()) {
                bean = new MgrParamScope();
                bean.setApiId(rs.getInt("api_id"));
                bean.setParamKey(rs.getString("token"));
                bean.setToken(rs.getString("param_key"));
                bean.setValue(rs.getString("value"));
                list.add(bean);
            }

            return list;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}