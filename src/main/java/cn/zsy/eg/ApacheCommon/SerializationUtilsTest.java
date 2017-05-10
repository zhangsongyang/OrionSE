package cn.zsy.eg.ApacheCommon;

import org.apache.commons.lang3.SerializationUtils;

public class SerializationUtilsTest {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        byte[] b = getBytes(teacher);
        Teacher teacher1 = SerializationUtils.deserialize(b); //反序列化
        System.out.println("Serialize: " + b.toString() + "\ndeSerialization: " + teacher1);
    }

    private static byte[] getBytes(Teacher teacher) {
        teacher.setAge(27);
        teacher.setName("zhangsongyang");
        return SerializationUtils.serialize(teacher);
    }

}
