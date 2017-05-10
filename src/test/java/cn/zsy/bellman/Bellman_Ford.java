package cn.zsy.bellman;

import java.util.Scanner;

public class Bellman_Ford {
    static final int MAX = 20;    //最大点数
    static Edge[] edges = new Edge[MAX];
    static int[] d = new int[MAX];
    static int vernum;
    static int edgenum;

    static void init() {
        for (int i = 0; i < vernum; i++) {
            d[i] = Integer.MAX_VALUE;
            edges[i] = new Edge(0, 0, Integer.MAX_VALUE);
        }
        d[0] = 0;
    }

    static class Edge {
        public int s;
        public int e;
        public int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
            next = null;
        }

        public Edge next;
    }

    static void input() {
        Scanner cin = new Scanner(System.in);
        System.out.println("---请输入 点数 边数");
        vernum = cin.nextInt();
        edgenum = cin.nextInt();
        int s, e, w;

        init();
        System.out.println("起点 终点 权值");
        for (int i = 0; i < edgenum; i++) {
            s = cin.nextInt();
            e = cin.nextInt();
            w = cin.nextInt();
            Edge edge = edges[s];
            while (edge.next != null) {
                edge = edge.next;
            }
            edge.next = new Edge(s, e, w);
        }
    }

    static boolean bellman_ford() {
        input();
        int s = 0, e = 0, w = 0;
        Edge edge = null;
        for (int i = 0; i < vernum - 1; i++) {
            //对所有的边进行松弛操作
            for (int j = 0; j < vernum; j++) {
                edge = edges[j];
                while (edge.next != null) {
                    edge = edge.next;
                    s = edge.s;
                    e = edge.e;
                    w = edge.w;
                    if (d[s] != Integer.MAX_VALUE) //防止溢出
                        d[e] = Math.min(d[s] + w, d[e]);
                }
            }
        }
        //遍历每条边
        for (int i = 0; i < vernum; i++) {
            edge = edges[i];
            while (edge.next != null) {
                edge = edge.next;
                s = edge.s;
                e = edge.e;
                w = edge.w;
                if (d[s] == Integer.MAX_VALUE) continue;//防止溢出
                if (d[e] > d[s] + w) return false;
            }
        }
        return true;
    }

    static void print() {
        for (int i = 0; i < vernum; i++) {
            System.out.println("d[" + i + "]: " + d[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(bellman_ford());
        print();
    }
}
