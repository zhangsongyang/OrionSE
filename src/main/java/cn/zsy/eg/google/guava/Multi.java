package cn.zsy.eg.google.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;

public class Multi {

    //http://blog.csdn.net/csujiangyu/article/details/50782823

    public static void main(String[] args) {
        String[] strings = new String[]{"a", "b", "c", "c", "c", "a"};
        Multiset<String> multiset = HashMultiset.create();
        for (String str : strings) {
            multiset.add(str);
        }
        //multiset存放方式为{"a" * 2, "b" * 1, "c" * 3}
        System.out.println(multiset.count("a"));
        System.out.println(multiset.count("b"));
        System.out.println(multiset.count("c"));
        System.out.println(multiset.elementSet());
        // 打印输出[b, c x 3, a x 2]
        System.out.println(multiset.entrySet());
        System.out.println(strings.length);
        System.out.println(multiset.size());

        //Multimap
        System.out.println("multimap.........");
        Multimap<String, Integer> multimap = HashMultimap.create();
        multimap.put("foo", 1);
        multimap.put("foo", 2);
        multimap.put("foo", 3);
        multimap.put("bar", 4);
        multimap.put("bar", 6);
        multimap.put("milk", 5);
        //一个key对应多个value
        System.out.println(multimap.get("foo"));
        //输出一个Multiset：[milk, foo x 3, bar x 2]
        System.out.println(multimap.keys());
        //返回key的集合
        System.out.println(multimap.keySet());
        //返回value的集合
        System.out.println(multimap.values());
        //输出一个Map<K, Collection<V>>：{milk=[5], foo=[1, 2, 3], bar=[4, 6]}
        System.out.println(multimap.asMap());
        //输出Collection<Map.Entry<K, V>>：[milk=5, foo=1, foo=2, foo=3, bar=4, bar=6]
        System.out.println(multimap.entries());



        //BiMap
        System.out.println("BiMap.........");
        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("foo", 1);
        biMap.put("bar", 2);
        biMap.put("mild", 3);
        //inverse()反转
        System.out.println(biMap.inverse().keySet());
        System.out.println(biMap.inverse().containsValue("foo"));



        //Table
        System.out.println("Table.........");
        Table<String, String, Integer> table = HashBasedTable.create();
        table.put("t11", "t12", 1);
        table.put("t11", "t22", 2);
        table.put("t21", "t22", 3);
        table.put("t31", "t32", 4);
        //输出：[(t21,t22)=3, (t11,t22)=2, (t11,t12)=1, (t31,t32)=4]
        System.out.println(table.cellSet());
        //输出：{t21={t22=3}, t11={t22=2, t12=1}, t31={t32=4}}
        System.out.println(table.rowMap());
        //输出：{t22={t21=3, t11=2}, t12={t11=1}, t32={t31=4}}
        System.out.println(table.columnMap());
        //返回row的keys
        System.out.println(table.rowKeySet());
        //返回column的keys
        System.out.println(table.columnKeySet());
        //获取value
        System.out.println(table.get("t21","t22"));
    }
}
