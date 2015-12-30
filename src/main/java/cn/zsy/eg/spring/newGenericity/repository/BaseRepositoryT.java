package cn.zsy.eg.spring.newGenericity.repository;


import java.io.Serializable;

public abstract class BaseRepositoryT<M extends Serializable> {

    public void save(M m) {
        System.out.println("=====repository save:" + m);
    }

}
