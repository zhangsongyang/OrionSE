package cn.zsy.eg.spring.service.impl;


import cn.zsy.eg.spring.repository.BaseRepository;
import cn.zsy.eg.spring.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private BaseRepository baseRepository;

    @Override
    public void saveService() {
        baseRepository.save();
        System.out.println("BaseServiceImpl.....");
    }

}
