package cn.zsy.eg.spring.newGenericity.service;


import cn.zsy.eg.spring.newGenericity.repository.BaseRepositoryT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

public abstract class BaseServiceT<M extends Serializable> {

    @Autowired
    private BaseRepositoryT<M> repositoryT;

    public void saveService(M m) {
        repositoryT.save(m);
        System.out.println("BaseService.....");
    }

}
