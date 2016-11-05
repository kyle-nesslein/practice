package practice.c4.p2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class DirectionalGraph {
	ArrayList<Vertex> vertices;
	
	public static void main(String args[]) {
		DirectionalGraph g = new DirectionalGraph();
		g.vertices = new ArrayList<Vertex>();
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		g.addVertex(7);
		g.addVertex(8);
		g.addVertex(9);
		g.addVertex(10);
		
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(3,4);
		g.addEdge(4,5);
		g.addEdge(5,8);
		g.addEdge(8,1);
		g.addEdge(8,10);
		
		Vertex found = g.BFS(g.getVertex(1), 10, new HashSet<Vertex>());
		if (found != null) {
		System.out.println(found.data);
		} else {
			System.out.println("Not found.");
		}

		
	}
	
	public Vertex DFS(Vertex v, Integer i, HashSet<Vertex> visitedSet) {
		visitedSet.add(v);
		if (v.data == i) {
			return v;
		}
		for (Vertex w : v.neighbors) {
			if (!visitedSet.contains(w)) {
				Vertex g = DFS(w, i, visitedSet);
				if (g!= null && g.data == i) {
					return g;
				}
			}
		}
		return null;
	}
	
	public Vertex BFS(Vertex v, Integer i, HashSet<Vertex> visitedSet) {
		visitedSet.add(v);
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		queue.addLast(v);
		while(!queue.isEmpty()) {
			 Vertex next = queue.removeFirst();
			 if (next.data == i) {
				 return next;
			 }
			 visitedSet.add(next);
			 for (Vertex w : next.neighbors) {
				 if (!visitedSet.contains(w)) {
					 queue.add(w);
				 }
			 }
		}
		return null;
	}


	private static class Vertex {
		ArrayList<Vertex> neighbors;
		Integer data;
		
		public Vertex(Integer value) {
			neighbors = new ArrayList<Vertex>();
			data = value;
		}
	}
	
	public void addVertex(Integer i) {
		vertices.add(new Vertex(i));
	}
	
	public void addEdge(Integer i, Integer j) {
		Vertex dest = null;
		for (Vertex w : vertices) {
			if (w.data == j) {
				dest = w;
			}
		}
		for (Vertex v : vertices) {
			if (v.data == i) {
				v.neighbors.add(dest);
			}
		}
	}
	
	public Vertex getVertex(Integer i) {
		for (Vertex v : vertices) {
			if (v.data == i) {
				return v;
			}
		}
		return null;
	}
}
