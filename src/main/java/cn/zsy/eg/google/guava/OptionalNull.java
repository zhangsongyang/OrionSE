package cn.zsy.eg.google.guava;

import com.google.common.base.Optional;

import java.util.List;

/**
 * Created by zhangsongyang on 5/25/2017.
 */
public class OptionalNull {

    public static void main(String[] args) {
        List list = null;
        if (Optional.fromNullable(list).isPresent()) {
            System.out.println("1");
        } else {
            System.out.println(2);
        }
    }

}
