package cn.zsy.eg.spring.repository.impl;


import cn.zsy.eg.spring.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BaseRepositoryImpl implements BaseRepository {

    @Override
    public void save() {
        System.out.println("BaseRepositoryImpl.....");
    }

}
