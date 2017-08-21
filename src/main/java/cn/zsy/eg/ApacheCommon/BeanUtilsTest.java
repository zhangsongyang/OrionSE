package cn.zsy.eg.ApacheCommon;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;

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
