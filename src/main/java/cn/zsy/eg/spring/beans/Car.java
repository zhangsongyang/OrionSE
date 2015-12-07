package cn.zsy.eg.spring.beans;


public class Car {

    private String colord;

    private String number;

    public String getColord() {
        return colord;
    }

    public void setColord(String colord) {
        this.colord = colord;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "colord='" + colord + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
