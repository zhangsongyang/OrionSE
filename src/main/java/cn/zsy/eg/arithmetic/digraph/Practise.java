package cn.zsy.eg.arithmetic.digraph;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Practise {

    public Practise(List<Edge<String>> roads) {
        this.roadList = roads;
    }

    public List<Edge<String>> getroadList() {
        return roadList;
    }

    public void setroadList(List<Edge<String>> roadList) {
        this.roadList = roadList;
    }

    public List<String> getbackList() {
        return backList;
    }

    public void setbackList(List<String> backList) {
        this.backList = backList;
    }

    public Set<String> getresultSet() {
        return resultSet;
    }

    public void setresultSet(Set<String> resultSet) {
        this.resultSet = resultSet;
    }



    List<Edge<String>> roadList = null; //
    List<String> backList = new ArrayList<String>(); //
    Set<String> resultSet = new HashSet<String>(); //
    Set<Edge<String>> cirList = new HashSet<Edge<String>>();    //

    /**
     *
     *
     * @param start
     * @param destination
     */
    public void getAllRoad(String start, String destination) {
        backList.add(start);
        for (int z = 0; z < roadList.size(); z++) {
            if (roadList.get(z).getSource().equals(start)) { //
                if (roadList.get(z).getDest().equals(destination)) { //
                    resultSet.add(backList.toString().substring(0, backList.toString().lastIndexOf("]")) + ", " + destination + "]");
                    continue;
                }
                if (!backList.contains(roadList.get(z).getDest())) {//�˽ڵ���δ���������������
                    getAllRoad(roadList.get(z).getDest(), destination);
                } else {
                    cirList.add(roadList.get(z));
                }
            }
        }
        backList.remove(start);
    }

    public Set<Edge<String>> getCirList() {
        return cirList;
    }

    public void setCirList(Set<Edge<String>> cirList) {
        this.cirList = cirList;
    }
}
