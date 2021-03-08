package com.southwind.service.impl;

import com.southwind.dao.HelloDao;
import com.southwind.dao.impl.HelloDaoImpl;
import com.southwind.factory.BeanFactory;
import com.southwind.service.HelloService;

import java.util.List;

public class HelloServiceImpl implements HelloService {

    public HelloServiceImpl() {
        for (int i = 0; i < 10; i++) {
            System.out.println(BeanFactory.getDao("helloDao"));
        }
    }

    private HelloDao helloDao = (HelloDao) BeanFactory.getDao("helloDao");

    @Override
    public List<String> findAll() {
        return this.helloDao.findAll();
    }
}
