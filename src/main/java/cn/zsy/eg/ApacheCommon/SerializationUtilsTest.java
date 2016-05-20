package cn.zsy.eg.ApacheCommon;

import org.apache.commons.lang3.SerializationUtils;

public class SerializationUtilsTest {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setAge(27);
        teacher.setName("zhangsongyang");
        byte[] b = SerializationUtils.serialize(teacher);     //序列化
        Teacher teacher1 = SerializationUtils.deserialize(b); //反序列化
        System.out.println("Serialize: " + b.toString() + "\ndeSerialization: " + teacher1);
    }

}
