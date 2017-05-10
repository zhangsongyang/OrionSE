package cn.zsy.alogrim;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MapVisit {
	/**
	 * 构造初始化路径--已知
	 * 
	 * @return
	 */
	public List<Road> init() {
		List<Road> list = new ArrayList<Road>();
		list.add(new Road("A", "B")); //A-->B 以此类推
		list.add(new Road("B", "C"));
		list.add(new Road("B", "E"));
		list.add(new Road("C", "B"));
		list.add(new Road("C", "D"));
		list.add(new Road("D", "F"));
		list.add(new Road("D", "Z"));
		list.add(new Road("E", "C"));
		list.add(new Road("E", "D"));
		list.add(new Road("E", "Z"));
		list.add(new Road("G", "B"));
		list.add(new Road("G", "F"));
		list.add(new Road("G", "F"));
		list.add(new Road("G", "H"));
		
		
		return list;
	}
	
	/**
	 * 判断所有路径中是否有以begin节点为起点的基本路径
	 * 
	 * @param begin
	 * @param roads
	 * @return
	 */
	public boolean existBegin(String begin, List<Road> roads) {
		if (begin.equals("Z")) {
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
	 * 判断所有路径中是否有以end节点为终点的基本路径
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
	 * 根据路径获取到所有的节点
	 * @param roads
	 * @return
	 */
	public Set<String> getAllNodes(List<Road> roads) {
		Set<String> nodes = new HashSet<String>();
		for(Road r : roads) {
			nodes.add(r.getBegin());
			nodes.add(r.getEnd());
		}
		return nodes;
	}

	/**
	 * 获取到需要删除的路径
	 * 
	 * @param begins
	 * ---无效起始节点
	 * @param ends
	 * ---无效终结点
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
	 * 过滤掉无用的节点
	 * 获取到无效开始节点和无效结束点
	 * @param all
	 * @return
	 */
	public Set<String> filterInvalidNode(Set<String> all, List<Road> roads,
			Set<String> begins, Set<String> ends) {
		Set<String> result = new HashSet<String>();
		boolean isBegin = true;
		boolean isEnd = true;
		for (String str : all) {
			if (!existEnd(str, roads)) { // 没有以此节点结尾的路径，则证明此节点为无用节点
				isBegin = false;
				begins.add(str);
				// 删除以此节点为开始的路径
				// this.deleteBegin(str, roads);
			} else if (!existBegin(str, roads)) {// 没有以此节点开头的路径，则证明此节点为无用节点
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
			return filterInvalidNode(result, roads, begins, ends);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MapVisit visit = new MapVisit();
		List<Road> roads = visit.init(); // 构造基本路径--为已知条件
		Set<String> invalidBegins = new HashSet<String>(); // 无效的起始节点
		Set<String> invalidEnds = new HashSet<String>(); // 无效的结束节点
		Set<String> allNodes = visit.getAllNodes(roads);
		visit.filterInvalidNode(allNodes, roads, invalidBegins, invalidEnds); //获取到无效开始节点和无效结束点
		Set<Road> invalidRoads = visit.deleteRoad(invalidBegins, invalidEnds,
				roads); // 获取需要删除的路径
		roads.removeAll(invalidRoads); // 删除无效的路径
		Practise pra = new Practise(roads);
		String begin = "A"; //起始点
		String end = "Z"; //终结点
		//獲取到有效路徑的核心方法
		pra.getAllRoad(begin, end);

		Iterator<String> it = pra.getresultSet().iterator();
		System.out.println("-----------------从" + begin + "至" + end + "的有效路径如下-----------------");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("-----------------其中下列路徑有回路-----------------");
		Set<Road> cir = pra.getCirList();
		for(Road r :cir) {
			System.out.println(r);
		}
		
		
		
		
	}

}
