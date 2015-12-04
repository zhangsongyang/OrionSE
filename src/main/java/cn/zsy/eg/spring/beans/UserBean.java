package cn.zsy.eg.spring.beans;

import java.util.Map;

public class UserBean {

    private String name;

    private String sex;

    private String school;

    private String old;

    private Map<String, String> course;


    public UserBean() {
    }

    public UserBean(String name, String sex, String school, String old) {
        this.name = name;
        this.sex = sex;
        this.school = school;
        this.old = old;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public Map<String, String> getCourse() {
        return course;
    }

    public void setCourse(Map<String, String> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", school='" + school + '\'' +
                ", old='" + old + '\'' +
                ", course=" + course +
                '}';
    }
}
