import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class GraphProblems {

	public static void main(String[] args) {
		Graph g = Graph.getTestGraph();
		g.print();
		g.Djikstras(0);
	}

}

class GraphNode{
	public int vertex;
	public int weight;
	
	public GraphNode(int vertex, int weight){
		this.vertex = vertex;
		this.weight = weight;
	}
	
}

class QueueNode{
	public int vertex;
	public int distance;
	public QueueNode(int vertex, int distance){
		this.vertex = vertex;
		this.distance = distance;
	}
	
	public static Comparator<QueueNode> comparator = new Comparator<QueueNode>() {
		
		@Override
		public int compare(QueueNode o1, QueueNode o2) {
			return o1.distance-o2.distance;
		}
	};
}

class Graph{
	int V;
	int E;
	HashMap<Integer, ArrayList<GraphNode>> adjList = new HashMap<Integer, ArrayList<GraphNode>>();
	
	public Graph(int V){
		this.V= V;
	}
	
	public void addEdge(int source, int dest, int weight, boolean undirected){
		ArrayList<GraphNode> list;
		if(adjList.containsKey(source)){
			list = adjList.get(source);
			if(!list.contains(dest))
				list.add(new GraphNode(dest, weight));
		}
		else{
			list = new ArrayList<GraphNode>();
			list.add(new GraphNode(dest, weight));
			adjList.put(source, list);
		}
		if(undirected){
			if(adjList.containsKey(dest)){
				list = adjList.get(dest);
				if(!list.contains(source))
					list.add(new GraphNode(source, weight));
			}
			else{
				list = new ArrayList<GraphNode>();
				list.add(new GraphNode(source, weight));
				adjList.put(dest, list);
			}
		}
	}
	
	public void Djikstras(int src){
		int[] distance = new int[V];
		PriorityQueue<QueueNode> queue = new PriorityQueue<QueueNode>(V, QueueNode.comparator);
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[src] = 0;
		int i=0;
		
		queue.add(new QueueNode(src, 0));
		while(i<=V-1){
			int tempSrc=-1;
			if(!queue.isEmpty()){
				QueueNode minDistanceNode = queue.poll();
				tempSrc = minDistanceNode.vertex;
			}
			ArrayList<GraphNode> list = adjList.get(tempSrc);
			for(GraphNode temp : list){
				int adjVertex = temp.vertex;
				if(distance[adjVertex]>distance[tempSrc]+temp.weight){
					distance[adjVertex] = distance[tempSrc]+temp.weight;
					queue.add(new QueueNode(adjVertex, distance[adjVertex]));
				}
			}
			i++;
		}
		for(i=0; i<V; i++){
			System.out.println(src+":"+i+"="+distance[i]);
		}
	}
	
	public static Graph getTestGraph(){
		Graph g = new Graph(9);
		boolean undirected = true;
		g.addEdge(0, 1, 4, undirected);
		g.addEdge(0, 7, 8, undirected);
		g.addEdge(1, 2, 8, undirected);
		g.addEdge(1, 7, 11, undirected);
		g.addEdge(2, 3, 7, undirected);
		g.addEdge(2, 5, 4, undirected);
		g.addEdge(2, 8, 2, undirected);
		g.addEdge(3, 4, 9, undirected);
		g.addEdge(3, 5, 14, undirected);
		g.addEdge(4, 5, 10, undirected);
		g.addEdge(5, 6, 2, undirected);
		g.addEdge(6, 7, 1, undirected);
		g.addEdge(6, 8, 6, undirected);
		g.addEdge(7, 8, 7, undirected);
		return g;
	}
	
	public void print(){
		for(Map.Entry<Integer, ArrayList<GraphNode>> entry : adjList.entrySet()){
			int source = entry.getKey();
			System.out.print(source+":");
			for(GraphNode edge : entry.getValue()){
				System.out.print("("+edge.vertex+" , "+edge.weight+"), ");
			}
			System.out.println();
		}
	}
	
	
	
}
