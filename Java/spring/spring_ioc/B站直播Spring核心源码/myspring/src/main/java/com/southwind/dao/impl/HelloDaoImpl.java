package com.southwind.dao.impl;

import com.southwind.dao.HelloDao;

import java.util.Arrays;
import java.util.List;

public class HelloDaoImpl implements HelloDao {
    @Override
    public List<String> findAll() {
        //连数据库
        return Arrays.asList("1","2","3");
    }
}
