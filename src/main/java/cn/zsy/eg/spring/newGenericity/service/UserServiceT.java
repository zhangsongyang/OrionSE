package cn.zsy.eg.spring.newGenericity.service;

import cn.zsy.eg.spring.newGenericity.entity.User;
import cn.zsy.eg.spring.newGenericity.repository.UserRepositoryT;
import org.springframework.stereotype.Service;

@Service
public class UserServiceT extends BaseServiceT<User> {

    private UserRepositoryT getUserRepository() {
        return (UserRepositoryT) baseRepositoryT;
    }

    public void selfService(){
        getUserRepository().selfSave();
        System.out.println("UserServiceT.....................selfService");
    }

}
