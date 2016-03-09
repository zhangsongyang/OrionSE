package cn.zsy.eg.fastjson;


import cn.zsy.eg.fastjson.entity.UserPOJO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.awt.*;
import java.util.Date;

public class FastJsonSerializer {


    public static void main(String[] args) {
        UserPOJO userPOJO = new UserPOJO();
        userPOJO.setId(1);
        userPOJO.setUserName("xsh");
        userPOJO.setOld("27");
        userPOJO.setInterest("xxx");
        userPOJO.setSchool("jd");
        //序列化就是把JavaBean对象转化成JSON格式的文本。
        String text = JSON.toJSONString(userPOJO);
        System.out.println(text);
        //标准的JSON是使用双引号的，javascript支持使用单引号格式的json文本，
        // fastjson也支持这个特性，打开SerializerFeature.UseSingleQuotes这个特性就可以了了
        String text1 = JSON.toJSONString(userPOJO, SerializerFeature.UseSingleQuotes);
        System.out.println(text1);
        System.out.println(JSON.toJSONString(userPOJO, SerializerFeature.BrowserCompatible));

        //fastjson直接支持日期类型数据的格式化，包括java.util.Date、java.sql.Date、java.sql.Timestamp、java.sql.Time。
        //缺省情况下，fastjson将Date类型序列化为long，这个使得序列化和反序列化的过程不会导致时区问题
        long millis = 1324138987429L;
        Date date = new Date(millis);
        System.out.println(JSON.toJSONString(date));

        //fastjson还提供了基于格式化输出的SerializerFeature，例如：
        System.out.println(JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat));

        //你可以指定输出日期的格式，比如修改为输出毫秒：
        System.out.println(JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:mm:ss.SSS"));

        Color color = Color.RED;
        String text2 = JSON.toJSONString(color, SerializerFeature.WriteClassName);
        System.out.println(text2);

        //由于序列化带了类型信息，使得反序列化时能够自动进行类型识别，例如：
        Color color1 = (Color) JSON.parse(text2);
        System.out.println(color1.getAlpha());
        String text3 = "{\"r\":255,\"g\":0,\"b\":0,\"alpha\":255}";
        Color color2 = JSON.parseObject(text3, Color.class);
        System.out.println(color2.getAlpha());

    }

}
