package cn.zsy.alogrim;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Practise {
	public Practise(List<Road> roads) {
		this.roadList = roads;
	}

	public List<Road> getroadList() {
		return roadList;
	}

	public void setroadList(List<Road> roadList) {
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

	List<Road> roadList = null; //已知的路径
	List<String> backList = new ArrayList<String>(); //存放已经访问过的节点
	Set<String> resultSet = new HashSet<String>(); //目的路径--访问结果
	Set<Road> cirList = new HashSet<Road>(); 	//回路
	
	/**
	 * 路径遍历的核心算法
	 * @param start
	 * ---需要寻找的起始节点。本案例为A
	 * @param destination
	 * ---需要寻找的终结点。本案例为Z
	 */
	public void getAllRoad(String start, String destination) {
		backList.add(start);
		for (int z = 0; z < roadList.size(); z++) {
			if (roadList.get(z).getBegin().equals(start)) { //寻找找以start开始的路径
				if (roadList.get(z).getEnd().equals(destination)) { //如果以destination结尾，则为一条有效路径
					resultSet.add(backList.toString().substring(0, backList.toString().lastIndexOf("]")) + "," + destination + "]");
					continue;
				}
				if (!backList.contains(roadList.get(z).getEnd())) {//此节点仍未遍历，则继续迭代
					getAllRoad(roadList.get(z).getEnd(), destination);
				} else {//證明有回路
					cirList.add(roadList.get(z));
					//System.out.println("wwww");
				}
			}
		}
		backList.remove(start);
	}

	public Set<Road> getCirList() {
		return cirList;
	}

	public void setCirList(Set<Road> cirList) {
		this.cirList = cirList;
	}
}
