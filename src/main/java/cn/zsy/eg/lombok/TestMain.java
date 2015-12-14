package cn.zsy.eg.lombok;


import lombok.extern.log4j.Log4j;

@Log4j
public class TestMain {

    public static void main(String[] args){
        UserBean userBean = new UserBean();
        userBean.setName("asdfsadfsadf");
        System.out.println(userBean.toString());
        UserBean userBean1 = new UserBean();
        userBean1.setName("sdf");
        UserBean u = new UserBean("asdf", 22, true);
        System.out.println(userBean.canEqual(userBean1));
        log.info("aSDFS");
    }

}
