package cn.zsy.eg.google.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ImmutableCollection {

    public static final ImmutableList<String> COLOR_NAMES = ImmutableList.of(
        "red",
        "orange",
        "yellow",
        "green",
        "blue",
        "purple",
        "red");


    public static void main(String[] args) {
        System.out.println(COLOR_NAMES.toString());
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        ImmutableList<String> defensiveCopy = ImmutableList.copyOf(list);
        list.add("444");
        System.out.println(defensiveCopy.toString());
        System.out.println(list.toString());




        //Java标准库支持
        Set<String> stringSet = Sets.newHashSet();
        Set<String> unmodifiableSet = Collections.unmodifiableSet(stringSet);
        //guava方式创建
        ImmutableList<String> unmodifiableList = ImmutableList.of("t1", "t2");
//        unmodifiableList.add("t3");
        //保护性拷贝
        ImmutableSet setCopy = ImmutableSet.copyOf(stringSet);
        //通过构造模式创建
        ImmutableSet.Builder<String> builder = ImmutableSet.builder();
        ImmutableSet<String> immutableSet = builder.add("RED").addAll(stringSet).build();
        System.out.println(immutableSet.toString());
    }

}
