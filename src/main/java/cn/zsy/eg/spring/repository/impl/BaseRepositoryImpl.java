package cn.zsy.eg.spring.repository.impl;


import cn.zsy.eg.spring.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository("baseRepositoryImpl")
public class BaseRepositoryImpl implements BaseRepository {

    @Override
    public void save(String x) {
        System.out.println("asdf");
        System.out.println(x);
    }

}
