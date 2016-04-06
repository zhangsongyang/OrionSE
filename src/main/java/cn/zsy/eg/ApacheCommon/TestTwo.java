package cn.zsy.eg.ApacheCommon;

import java.util.ArrayList;
import java.util.List;

public class TestTwo {

    public static void main(String[] args) {
        StudentTwo student = new StudentTwo();
        student.setName("鸣人");
        student.setAge(34);
        List<StudentTwo> list = new ArrayList<StudentTwo>();
        list.add(student);
        TeacherTwo teacher = new TeacherTwo();
        teacher.setName("卡卡西");
        teacher.setAge(33);
        teacher.setStudent(list);

        try {
            TeacherTwo cloneTeacher = (TeacherTwo) teacher.clone();
            System.out.println("修改前teacher：" + teacher);
            System.out.println("修改前cloneTeacher：" + cloneTeacher);
            System.out.println("--modify--");
            student.setName("佐助");
            student.setAge(33);
            System.out.println("修改后teacher：" + teacher);
            System.out.println("修改后cloneTeacher：" + cloneTeacher);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
