package cn.zsy.eg.ApacheCommon;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

public class TeacherTwo implements Cloneable, Serializable {

    private String name;
    private int age;
    private List<StudentTwo> student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<StudentTwo> getStudent() {
        return student;
    }

    public void setStudent(List<StudentTwo> student) {
        this.student = student;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return SerializationUtils.clone(this); //深克隆
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
