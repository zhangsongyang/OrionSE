package cn.zsy.eg.ApacheCommon;

import org.springframework.beans.BeanUtils;

public class BeanUtilsTest {

    public static void main(String[] args) {
        Student studentSource = new Student();
        studentSource.setName("zhangsongyang");
        studentSource.setAge(28);
        StudentCopy studentCopyTarget = new StudentCopy();
        BeanUtils.copyProperties(studentSource, studentCopyTarget);
        System.out.println(studentCopyTarget.toString());

    }

}
