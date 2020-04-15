package cn.zsy.eg.slfFj;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class TestSlfFj {

    private static final Logger logger = LoggerFactory.getLogger(TestSlfFj.class);
    private static final Logger loggerq = LoggerFactory.getLogger("sadfsadfas");

    public static void main(String[] args) {
        Map<String, String> madd = new HashMap<>();
        System.out.println(madd.get("asdf"));
        JSONObject responseJson = JSON.parseObject(null);
        if(null != responseJson){

            System.out.println(responseJson.getString("asf"));
        }

        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.warn("This is warn message");
        logger.error("This is error message");
        logger.info("{} is {}", new String[]{"x","y"});
        logger.info("{1,2} is {}", "2");
        System.out.println(responseJson.getString("asf"));

        NullPointerException e = new NullPointerException();
        logger.error("dubboAccountServiceg getUserInfo has a error, uhomeUserId:{}, AccoutToken:{}",
            "asdfasdf", "234234234", e);
        loggerq.info("xxxxxxx");
    }

}
