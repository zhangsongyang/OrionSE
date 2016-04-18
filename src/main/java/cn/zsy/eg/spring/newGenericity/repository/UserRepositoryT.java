package cn.zsy.eg.spring.newGenericity.repository;


import cn.zsy.eg.spring.newGenericity.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryT extends BaseRepositoryT<User> {

    public void selfSave(){
        System.out.println("UserRepositoryT.......selfSave");
    }


}
