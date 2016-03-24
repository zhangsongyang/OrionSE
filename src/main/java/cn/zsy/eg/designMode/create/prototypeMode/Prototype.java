package cn.zsy.eg.designMode.create.prototypeMode;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * 原型模式
 * 该模式的思想就是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象。
 * 说道复制对象，我将结合对象的浅复制和深复制来说一下，首先需要了解对象深、浅复制的概念：
 * 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
 */
public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private int base;

    private Integer obj;

    /* 浅复制 */
    public Object clone() throws CloneNotSupportedException {
        // 因为Cloneable接口是个空接口，你可以任意定义实现类的方法名
        // 如cloneA或者cloneB，因为此处的重点是super.clone()这句话
        // super.clone()调用的是Object的clone()方法
        // 而在Object类中，clone()是native（本地方法）的
        Prototype proto = (Prototype) super.clone();
        return proto;
    }

    /* 深复制 */
    public Object deepClone() throws IOException, ClassNotFoundException {

        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public Integer getObj() {
        return obj;
    }

    public void setObj(Integer obj) {
        this.obj = obj;
    }

}
