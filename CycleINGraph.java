import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CycleINGraph {
	static int v=5;
	static ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>(v);
	
	static ArrayList<ArrayList<Integer>> l2 = new ArrayList<ArrayList<Integer>>(v);
	
	static GraphbyAdjList graph = new GraphbyAdjList();
	public static void main(String[] args) {
		
		//1. Make a Adjacency list
		for(int i =0;i<v;i++) {
			l.add(new ArrayList<Integer>());
		}
			graph.addEdge(l,0,1);
			graph.addEdge(l,0,2);
			graph.addEdge(l,2,3);
			graph.addEdge(l,3,1);
			graph.addEdge(l,3,4);
			
			for(int i =0;i<v;i++) {
				l2.add(new ArrayList<Integer>());
			}
			
			graph.addEdge(l2,0,1);
			graph.addEdge(l2,0,4);
			graph.addEdge(l2,1,4);
			graph.addEdge(l2,1,2);
			graph.addEdge(l2,3,1);
			graph.addEdge(l2,2,3);
			graph.addEdge(l2,3,4);
		
		//2. Make a Map --> This will always be a static map. No matter what inputs for the Graph are provided
		Map<Integer, Integer> deg = putDegreeInMap(l);	
		Map<Integer, Integer> deg2 = putDegreeInMap(l2);	
		//Make a queue --> For different inputs this will fail as Map key's are static
		Map<Integer, String> que = makeQueue(l.size());
		Map<Integer, String> que2 = makeQueue(l2.size());
		//Iterate through map
		findCycle(deg, que,l);
		findCycle(deg2, que2,l2);
			
		printCyclicVertices(que);
		printCyclicVertices(que2);
		
		
	}
	public static void findCycle(Map<Integer, Integer> deg, Map<Integer, String> que,ArrayList<ArrayList<Integer>> l) {
		for(int i =0;i<v;i++) {
			if(deg.get(i)==1) {
				que.put(i, "V");
				for( int j =0; j < l.get(i).size();j++) {
					deg.put(l.get(i).get(j), deg.get(l.get(i).get(j))-1);
					if(deg.get(l.get(i).get(j))==1)   que.put(l.get(i).get(j), "V");
				}
			}
		}
	}
	public static void printCyclicVertices(Map<Integer, String> que) {
		System.out.println("Cyclic vertices are");
		for(int i =0;i<v;i++) {
			if(que.get(i)!="V") {
				System.out.println(i);
			}
		}
	}
	public static Map<Integer, String> makeQueue(int size) {
		Map<Integer,String> que = new HashMap<>();
		for(int i =0; i<size;i++) {
			que.put(i, "U");
		}
		return que;
	}
	public static Map<Integer, Integer> putDegreeInMap(ArrayList<ArrayList<Integer>> l) {
		Map<Integer,Integer> deg = new HashMap<>();
		for(int i=0;i<v;i++) {
			deg.put(i, l.get(i).size());
		}
		return deg;
	}
}
