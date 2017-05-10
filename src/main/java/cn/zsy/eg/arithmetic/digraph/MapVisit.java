package cn.zsy.eg.arithmetic.digraph;

import java.util.*;

import static cn.zsy.eg.arithmetic.digraph.InitGraph.INF;
import static cn.zsy.eg.arithmetic.digraph.InitGraph.edgeMap;


public class MapVisit {
    /**
     * 构造初始化路径--已知
     *
     * @return
     */
    public List<Edge<String>> init() {
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

    /**
     * 判断所有路径中是否有以begin节点为起点的基本路径
     *
     * @param begin
     * @param roads
     * @return
     */
    public boolean existBegin(String begin, String end, List<Edge<String>> roads) {
        if (begin.equals(end)) {
            return true;
        }
        boolean result = false;
        for (Edge<String> r : roads) {
            if (r.getSource().equals(begin)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 判断所有路径中是否有以end节点为终点的基本路径
     *
     * @param end
     * @param roads
     * @return
     */
    public boolean existEnd(String begin, String end, List<Edge<String>> roads) {
        if (end.equals(begin)) {
            return true;
        }
        boolean result = false;
        for (Edge<String> r : roads) {
            if (r.getDest().equals(end)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 根据路径获取到所有的节点
     *
     * @param edges
     * @return
     */
    public Set<String> getAllNodes(List<Edge<String>> edges) {
        Set<String> nodes = new HashSet<String>();
        for (Edge<String> r : edges) {
            nodes.add(r.getSource());
            nodes.add(r.getDest());
        }
        return nodes;
    }

    /**
     * 获取到需要删除的路径
     *
     * @param sources ---无效起始节点
     * @param edges
     */
    public Set<Edge<String>> deleteRoad(Set<String> sources, List<Edge<String>> edges) {
        Set<Edge<String>> set = new HashSet<Edge<String>>();
        for (String str : sources) {
            for (Edge<String> r : edges) {
                if (r.getSource().equals(str)) {
                    set.add(r);
                }
                if (r.getDest().equals(str)) {
                    set.add(r);
                }
            }
        }
        return set;
    }

    /**
     * 过滤掉无用的节点
     * 获取到无效开始节点和无效结束点
     *
     * @param all
     * @return
     */
    public Set<String> filterInvalidNode(Set<String> all, List<Edge<String>> roads,
                                         Set<String> begins, Set<String> ends, String begin, String end) {
        Set<String> result = new HashSet<String>();
        boolean isBegin = true;
        boolean isEnd = true;
        for (String str : all) {
            if (!existEnd(begin, str, roads)) { // 没有以此节点结尾的路径，则证明此节点为无用节点
                isBegin = false;
                begins.add(str);
                // 删除以此节点为开始的路径
                // this.deleteBegin(str, roads);
            } else if (!existBegin(str, end, roads)) {// 没有以此节点开头的路径，则证明此节点为无用节点
                isEnd = false;
                ends.add(str);
                // this.deleteEnd(str, roads);
            } else {
                result.add(str); // 有用的节点
            }
        }
        if (isBegin == true && isEnd == true) {
            return result;
        } else {
            return filterInvalidNode(result, roads, begins, ends, begin, end);
        }
    }

    public static Map<String, Double> route(String src, String dest) {
        Map<String, Double> pathMap = new HashMap<String, Double>();
        MapVisit visit = new MapVisit();
        List<Edge<String>> roads = visit.init(); // 构造基本路径--为已知条件
        Set<String> invalidBegins = new HashSet<String>(); // 无效的起始节点
        Set<String> invalidEnds = new HashSet<String>(); // 无效的结束节点
        Set<String> allNodes = visit.getAllNodes(roads);
        visit.filterInvalidNode(allNodes, roads, invalidBegins, invalidEnds, src, dest); //获取到无效开始节点和无效结束点
        Set<Edge<String>> invalidRoads = visit.deleteRoad(invalidBegins, roads); // 获取需要删除的路径
        roads.removeAll(invalidRoads); // 删除无效的路径
        Practise pra = new Practise(roads);
        pra.getAllRoad(src, dest);

        Iterator<String> it = pra.getresultSet().iterator();
        System.out.println("-----------------from " + src + " to " + dest + " valid path-----------------");
        while (it.hasNext()) {
            String path = it.next();
            pathMap.put(path.replace(", ", "-").replace("[", "").replace("]", ""), pathDistance(path));
        }
        System.out.println(pathMap.toString());
        return pathMap;
    }


    public static double pathDistance(String path) {
        double distance = 0;
        String[] node = path.replace("[", "").replace("]", "").split(",");
        for (int i = 0; i < node.length - 1; i++) {
            String key = node[i].trim() + "-" + node[i + 1].trim();
            double nodeLen = edgeMap().get(key) == null ? INF : edgeMap().get(key);
            distance += nodeLen;
        }
        return distance;
    }

    public static void main(String[] args) {
        route("A", "D");
    }


}
