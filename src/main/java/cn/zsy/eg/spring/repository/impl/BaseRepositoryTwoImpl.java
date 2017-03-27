package cn.zsy.eg.spring.repository.impl;


import cn.zsy.eg.spring.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository("baseRepositoryTwoImpl")
public class BaseRepositoryTwoImpl implements BaseRepository {

    @Override
    public void save(String x) {
        System.out.println("BaseRepositoryImpl.....");
    }

}
