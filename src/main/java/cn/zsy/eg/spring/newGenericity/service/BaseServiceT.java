package cn.zsy.eg.spring.newGenericity.service;


import cn.zsy.eg.spring.newGenericity.repository.BaseRepositoryT;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class BaseServiceT<M extends Serializable> {

    @Autowired
    protected BaseRepositoryT<M> baseRepositoryT;


    public void saveService(M m) {
        baseRepositoryT.save(m);
        System.out.println("BaseService....." + baseRepositoryT.getClass());
    }

}
