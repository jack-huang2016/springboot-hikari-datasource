package com.sample.test.web.controller;

import com.sample.test.common.MgrParamScope;
import com.sample.test.dao.DataSourceTest2Dao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/testDataSource")
public class HikariDataSourceController {

    @Autowired
    private DataSourceTest2Dao dataSourceTest2Dao;

    @RequestMapping("/selectAll2")
    public ResponseEntity<List<MgrParamScope>> selectAll2(){
        List<MgrParamScope> ds3List = null;
        try {
            ds3List = dataSourceTest2Dao.selectAll2();
            return ResponseEntity.ok(ds3List);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("/selectAll3")
    public ResponseEntity<List<MgrParamScope>> selectAll3(){
        List<MgrParamScope> ds3List = null;
        try {
            ds3List = dataSourceTest2Dao.selectAll3();
            return ResponseEntity.ok(ds3List);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("/selectAll4")
    public ResponseEntity<List<MgrParamScope>> selectAll4(){
        List<MgrParamScope> ds3List = null;
        try {
            ds3List = dataSourceTest2Dao.selectAll4();
            return ResponseEntity.ok(ds3List);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
