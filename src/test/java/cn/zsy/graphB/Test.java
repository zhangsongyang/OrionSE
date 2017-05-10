package cn.zsy.graphB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangsongyang on 2017/1/25.
 */
public class Test {

//    public static void main(String[] args) {
////        String[] vertex = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k" };
//        String[] vertex = { "a", "b", "c", "d", "e"};
////        double[][] matrix = {
////                { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
////                { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
////                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
////                { 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
////                { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
////                { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
////                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
////                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
////                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
////                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
////                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
////
//        int[][] matrix = {
//                {0, 1, 0, 1, 1},
//                {0, 0, 1, 0, 0},
//                {0, 0, 0, 1, 1},
//                {0, 0, 1, 0, 1},
//                {0, 1, 0, 0, 0}};
//
//
//        Graph<String> graph = new Graph<>(matrix, vertex);
//        System.out.println(graph.startSearch());
//    }

    public static void main(String[] args) {
        List<Road> list = new ArrayList<Road>();
        list.add(new Road("A", "B")); //AB5，BC4，CD8，DC8，DE6，AD5，CE2，EB3，AE7
        list.add(new Road("B", "C"));
        list.add(new Road("C", "D"));
        list.add(new Road("D", "C"));
        list.add(new Road("D", "E"));
        list.add(new Road("A", "D"));
        list.add(new Road("C", "E"));
        list.add(new Road("E", "B"));
        list.add(new Road("A", "E"));
        if(list.contains(new Road("A", "X"))){
            System.out.println("A");
        }else {
            System.out.println("B");
        }
    }

}
