package cn.zsy.graphB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MapVisit {
    /**
     * �����ʼ��·��--��֪
     *
     * @return
     */
    public List<Road> init() {
        List<Road> list = new ArrayList<Road>();
        list.add(new Road("A", "B")); //AB5��BC4��CD8��DC8��DE6��AD5��CE2��EB3��AE7
        list.add(new Road("B", "C"));
        list.add(new Road("C", "D"));
        list.add(new Road("D", "C"));
        list.add(new Road("D", "E"));
        list.add(new Road("A", "D"));
        list.add(new Road("C", "E"));
        list.add(new Road("E", "B"));
        list.add(new Road("A", "E"));

        return list;
    }

    /**
     * �ж�����·�����Ƿ�����begin�ڵ�Ϊ���Ļ���·��
     *
     * @param begin
     * @param roads
     * @return
     */
    public boolean existBegin(String begin, List<Road> roads) {
        if (begin.equals("C")) {
            return true;
        }
        boolean result = false;
        for (Road r : roads) {
            if (r.getBegin().equals(begin)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * �ж�����·�����Ƿ�����end�ڵ�Ϊ�յ�Ļ���·��
     *
     * @param end
     * @param roads
     * @return
     */
    public boolean existEnd(String end, List<Road> roads) {
        if (end.equals("A")) {
            return true;
        }
        boolean result = false;
        for (Road r : roads) {
            if (r.getEnd().equals(end)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * ����·����ȡ�����еĽڵ�
     *
     * @param roads
     * @return
     */
    public Set<String> getAllNodes(List<Road> roads) {
        Set<String> nodes = new HashSet<String>();
        for (Road r : roads) {
            nodes.add(r.getBegin());
            nodes.add(r.getEnd());
        }
        return nodes;
    }

    /**
     * ��ȡ����Ҫɾ����·��
     *
     * @param begins ---��Ч��ʼ�ڵ�
     * @param ends   ---��Ч�ս��
     * @param roads
     */
    public Set<Road> deleteRoad(Set<String> begins, Set<String> ends,
                                List<Road> roads) {
        Set<Road> set = new HashSet<Road>();
        for (String str : begins) {
            for (Road r : roads) {
                if (r.getBegin().equals(str)) {
                    set.add(r);
                }
                if (r.getEnd().equals(str)) {
                    set.add(r);
                }
            }
        }
        return set;
    }

    /**
     * ���˵����õĽڵ�
     * ��ȡ����Ч��ʼ�ڵ����Ч������
     *
     * @param all
     * @return
     */
    public Set<String> filterInvalidNode(Set<String> all, List<Road> roads,
                                         Set<String> begins, Set<String> ends) {
        Set<String> result = new HashSet<String>();
        boolean isBegin = true;
        boolean isEnd = true;
        for (String str : all) {
            if (!existEnd(str, roads)) { // û���Դ˽ڵ��β��·������֤���˽ڵ�Ϊ���ýڵ�
                isBegin = false;
                begins.add(str);
                // ɾ���Դ˽ڵ�Ϊ��ʼ��·��
                // this.deleteBegin(str, roads);
            } else if (!existBegin(str, roads)) {// û���Դ˽ڵ㿪ͷ��·������֤���˽ڵ�Ϊ���ýڵ�
                isEnd = false;
                ends.add(str);
                // this.deleteEnd(str, roads);
            } else {
                result.add(str); // ���õĽڵ�
            }
        }
        if (isBegin == true && isEnd == true) {
            return result;
        } else {
            return filterInvalidNode(result, roads, begins, ends);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MapVisit visit = new MapVisit();
        List<Road> roads = visit.init(); // �������·��--Ϊ��֪����
        Set<String> invalidBegins = new HashSet<String>(); // ��Ч����ʼ�ڵ�
        Set<String> invalidEnds = new HashSet<String>(); // ��Ч�Ľ����ڵ�
        Set<String> allNodes = visit.getAllNodes(roads);
        visit.filterInvalidNode(allNodes, roads, invalidBegins, invalidEnds); //��ȡ����Ч��ʼ�ڵ����Ч������
        Set<Road> invalidRoads = visit.deleteRoad(invalidBegins, invalidEnds,
                roads); // ��ȡ��Ҫɾ����·��
        roads.removeAll(invalidRoads); // ɾ����Ч��·��
        Practise pra = new Practise(roads);
        String begin = "C"; //��ʼ��
        String end = "C"; //�ս��
        //�@ȡ����Ч·���ĺ��ķ���
        pra.getAllRoad(begin, end);

        Iterator<String> it = pra.getresultSet().iterator();
        System.out.println("-----------------��" + begin + "��" + end + "����Ч·������-----------------");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("-----------------��������·���л�·-----------------");
        Set<Road> cir = pra.getCirList();
        for (Road r : cir) {
            System.out.println(r);
        }


    }

}
