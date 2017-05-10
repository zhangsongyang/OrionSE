package cn.zsy.eg.arithmetic.digraph;


import java.util.*;

/**
 * 迪科斯彻算法（Dijkstra）是由荷兰计算机科学家艾兹格•迪科斯彻（Edsger Wybe Dijkstra）发明的。
 * 算法解决的是有向图中单个源点到其他顶点的最短路径问题。
 * 算法参考：
 * http://baike.baidu.com/item/%E8%BF%AA%E6%9D%B0%E6%96%AF%E7%89%B9%E6%8B%89%E7%AE%97%E6%B3%95?fromtitle=%E8%BF%AA%E7%A7%91%E6%96%AF%E5%BD%BB%E7%AE%97%E6%B3%95&fromid=8595939&type=syn
 */
public class Digraph {

    private double[][] graph;//加权有向图
    private int start;//源点编号 从 0开始
    private int dimention;
    static int INF = InitGraph.INF;
    //用于标记顶点是否已经计算
    private Set<Integer> vertexSet = new HashSet<Integer>();
    //存储结果，Map的key对应各终点编号，value对应路径编号列表。
    private Map<Integer, List<Integer>> pathListMap = new HashMap<Integer, List<Integer>>();

    /**
     * 构造函数，必须初始化路径矩阵和起始点
     *
     * @param graph
     * @param start
     */
    public Digraph(double[][] graph, int start) {
        this.graph = graph;
        this.start = start;
        this.dimention = graph.length;
        calculate();
    }

    /**
     * 计算函数
     */
    private void calculate() {
        //初始化
        for (int end = 0; end < dimention; end++) {
            if (end == start) {
                continue;
            }//起始点自己的路径排除。
            List<Integer> pathList = new ArrayList<Integer>();
            pathList.add(start);//每条路径的起始点都为start，pathList只记录编号，不记录路径权值
            pathList.add(end);//每条路径的第二个参数为终点编号
            pathListMap.put(end, pathList);
        }
        //计算主体
        for (int bridge = 0; bridge < dimention; bridge++) {
            if (bridge == start) {
                continue;
            }
            if (!vertexSet.contains(bridge)) {//确保每个基点只循环计算一次
                for (int next = 0; next < dimention; next++) {
                    if (next == start || next == bridge) {
                        continue;
                    }
                    if (startTo(bridge) + getRawLength(bridge, next) < startTo(next)) {
                        List<Integer> pathList = pathListMap.get(next);
                        List<Integer> bridgePathList = pathListMap.get(bridge);
                        //清空，使用新的
                        pathList.clear();
                        pathList.addAll(bridgePathList);
                        pathList.add(next);
                    }
                }
            }
            vertexSet.add(bridge);
        }
        //检查，是否桥接的路径都被更新
        for (int end = 0; end < dimention; end++) {
            if (end == start) {
                continue;
            }
            List<Integer> pathList = pathListMap.get(end);
            int size = pathList.size();
            if (size > 2) {
                for (int end2 = 0; end2 < dimention; end2++) {
                    int isEnd = pathList.get(size - 2);
                    if (end2 == isEnd) {
                        pathList.clear();
                        pathList.addAll(pathListMap.get(end2));
                        pathList.add(end);
                    }
                }
            }
        }
    }

    /**
     * 获取当前指定路径的长度
     *
     * @param end
     * @return
     */
    private int startTo(int end) {
        int pathLen = 0;
        List<Integer> pathList = pathListMap.get(end);
        for (int i = 0; i < pathList.size() - 1; i++) {
            pathLen += graph[pathList.get(i)][pathList.get(i + 1)];
        }
        return pathLen;
    }

    /**
     * 直接提取矩阵中的相邻路径。
     *
     * @param start
     * @param end
     * @return
     */
    private double getRawLength(int start, int end) {
        if (end == start) {
            return 0;
        }
        return graph[start][end];
    }

    /**
     * 得到指定目标的路劲长度
     *
     * @param end
     * @return
     */
    public int getLength(int end) {
        if (end == start) {
            return 0;
        }
        return startTo(end);
    }

    /**
     * 在控制台打印输出所有路径编号
     */
    public void printResult() {
        System.out.println(pathListMap);
    }


    public static Map<String, String> nodeDistance() {
        Map<String, String> distance = new HashMap<String, String>();
        double[][] graph = InitGraph.matrix();
        int start = 0;
        int end = 0;
        int length = graph.length;
        for (start = 0; start < length; start++) {
            Digraph dijkstra = new Digraph(graph, start);
            dijkstra.printResult();
            for (end = 0; end < length; end++) {
                if (end == start) {
                    continue;
                }
                int len = dijkstra.getLength(end);
                System.out.println(" Length(" + Node.getNote(start) + "-" + Node.getNote(end) + ") = " + ((len == INF) ? "Infinity" : len));
                StringBuilder key = new StringBuilder();
//                distance.put(dijkstra.path(dijkstra.pathListMap.get(end)), ((len == INF) ? "NO SUCH ROUTE" : String.valueOf(len)));
                distance.put(key.append(Node.getNote(start)).append("-").append(Node.getNote(end)).toString(), ((len == INF) ? "NO SUCH ROUTE" : String.valueOf(len)));
            }
        }
        System.out.println(distance.toString());
        return distance;
    }

    private String path(List<Integer> list) {
        StringBuilder key = new StringBuilder();  //A-B
        for (int i = 0; i < list.size(); i++) {
            key.append(Node.getNote(list.get(i)));
            if (i != (list.size() - 1)) {
                key.append("-");
            }
        }
        return key.toString();
    }

    public static void main(String[] args) {
        nodeDistance();
    }
}

