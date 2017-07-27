package cn.zsy.eg.google.guava;


import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

import java.util.Set;

public class IterablesTest {

    public static void main(String[] args) {
        Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4);
        Set<Integer> set2 = Sets.newHashSet(5, 6, 7, 8);
        //串联多个集合 containsInAnyOrder(1, 2, 3, 4, 5, 6, 7, 8)
        System.out.println(Iterables.concat(set1, set2));
        //输出：[[1, 2], [3, 4]]
        System.out.println(Iterables.partition(set1, 2));
        //所有元素满足条件就返回true
        System.out.println(Iterables.all(set1, new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                if (input % 2 == 0)
                    return false;
                else
                    return true;
            }
        }));
        //如果有一个元素满足条件就返回true
        System.out.println(Iterables.any(set1, new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                if (input % 2 == 0)
                    return false;
                else
                    return true;
            }
        }));
        //返回满足条件的第一个元素
        int i = Iterables.find(set1, new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                if (input % 2 == 0)
                    return false;
                else
                    return true;
            }
        });
        System.out.println(i);
        //过滤满足条件的元素，这里返回集合里面的奇数
        Iterable<Integer> odds = Iterables.filter(set1, new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                if (input % 2 == 0)
                    return false;
                else
                    return true;
            }
        });
        System.out.println(odds);
        //返回对象在iterable中出现的次数
        System.out.println(Iterables.frequency(set1, 2));
    }

}
