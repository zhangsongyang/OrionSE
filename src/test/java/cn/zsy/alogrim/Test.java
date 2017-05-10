package cn.zsy.alogrim;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangsongyang on 2017/2/10.
 */
public class Test {

    public static List<Edge<String>> edgeList() {
        List<Edge<String>> list = new ArrayList();
        Scanner cin = new Scanner(System.in);
        System.out.println("please edges:");
        int edges = cin.nextInt();
        System.out.println("起点 终点 权值");
        String src;
        String dest;
        double weight;
        for (int i = 0; i < edges; i++) {
            src = cin.next();
            dest = cin.next();
            weight = cin.nextDouble();
            list.add(new Edge<String>(src, dest, weight));
        }
        return list;
    }


}
