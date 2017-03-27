package cn.zsy.eg.spring.service.impl;


import cn.zsy.eg.spring.repository.BaseRepository;
import cn.zsy.eg.spring.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    @Qualifier("baseRepositoryTwoImpl")
    private BaseRepository baseRepository;

    @Override
    public void saveService() {
        baseRepository.save("222");
        System.out.println("BaseServiceImpl.....");
    }

}
