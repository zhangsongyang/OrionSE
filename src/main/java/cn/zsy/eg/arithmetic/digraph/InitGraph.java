package cn.zsy.eg.arithmetic.digraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitGraph {

    public static int INF = Integer.MAX_VALUE;

    public static List<Edge<String>> edgeList() {
        List<Edge<String>> list = new ArrayList();
        list.add(new Edge("A", "B", 5)); //AB5，BC4，CD8，DC8，DE6，AD5，CE2，EB3，AE7
        list.add(new Edge("B", "C", 4));
        list.add(new Edge("C", "D", 8));
        list.add(new Edge("D", "C", 8));
        list.add(new Edge("D", "E", 6));
        list.add(new Edge("A", "D", 5));
        list.add(new Edge("C", "E", 2));
        list.add(new Edge("E", "B", 3));
        list.add(new Edge("A", "E", 7));
        return list;
    }

    public static Map<String, Double> edgeMap() {
        Map<String, Double> map = new HashMap<String, Double>();
        List<Edge<String>> list = edgeList();
        for (Edge<String> edge : list) {
            map.put(edge.getRoute(), edge.getWeight());
        }
        return map;
    }

    /**
     * 构造邻接矩阵
     * @return
     */
    public static double[][] matrix() {
        double[][] matrix = new double[Node.values().length][Node.values().length];
        for (int i = 0; i < Node.values().length; i++) {
            for (int j = 0; j < Node.values().length; j++) {
                matrix[i][j] = edgeMap().get(Node.getNote(i) + "-" + Node.getNote(j)) == null ? INF : edgeMap().get(Node.getNote(i) + "-" + Node.getNote(j));
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        double[][] m =  matrix();
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print(m[i][j] + "   ");
            }
            System.out.println("\n");
        }
    }


}
