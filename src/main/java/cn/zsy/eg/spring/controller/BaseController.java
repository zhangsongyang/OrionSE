package cn.zsy.eg.spring.controller;

import cn.zsy.eg.spring.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BaseController {

    @Autowired
    private BaseService baseService;

    public void saveController() {
        baseService.saveService();
        System.out.println("BaseController.........");
    }


}
