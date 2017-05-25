import java.util.ArrayList;
import java.util.HashSet;

public class Graph {
	ArrayList<Vertex> vertices;
	
	public Graph() {
		vertices = new ArrayList<Vertex>();
	}
	
	public static void main(String args[]) {
		Graph graph = new Graph();
		Vertex v = graph.addVertex(20);
		graph.addVertex(10);
		graph.addVertex(14);
		graph.addVertex(22);
		graph.addVertex(21);
		graph.addEdge(10, 20); 
		graph.addEdge(20, 22);
		
		System.out.println(graph.DFS(v, 22).value);


	}
	
	public Vertex addVertex(Integer i) {
		Vertex v = new Vertex(i);
		vertices.add(v);
		return v;
	}
	
	public void addEdge(Integer i, Integer j) {
		for (Vertex v : vertices) {
			if (v.value ==i) {
				v.addNeighbor(j);
				
			}
		}
	}
	
	public Vertex DFS(Vertex v, Integer i) {
		return DFS(v,i, new HashSet<Vertex>());
	}
	
	public Vertex DFS(Vertex v, Integer i, HashSet<Vertex> visited) {
		if (v.value == i) {
			return v;
		}
		for (Vertex w : v.neighbors) {
			if (!visited.contains(w)) {
				visited.add(w);
				return DFS(w, i, visited);
			}
		}
		return null;
	}
	
	public Vertex BFS(Vertex v, Integer i) {
		HashSet<Vertex> visited = new HashSet<Vertex>();
	}

	private static class Vertex {
		Integer value;
		ArrayList<Vertex> neighbors;
		
		public Vertex(Integer i) {
			value = i;
			neighbors = new ArrayList<Vertex>();
		}
		
		public void addNeighbor(Integer i) {
			neighbors.add(new Vertex(i));
		}
	}
}
