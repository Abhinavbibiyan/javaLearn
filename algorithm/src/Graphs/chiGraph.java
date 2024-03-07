package Graphs;

import java.util.*;

public class chiGraph {
	private int numOfVertices;
	private int numOfEdges;
	private LinkedList<Integer> adjacencyList[];

	@SuppressWarnings("unchecked")
	chiGraph(int n) {
		numOfVertices = n;
		numOfEdges = 0;
		adjacencyList = new LinkedList[n];
		for (int i = 0; i < n; ++i)
			adjacencyList[i] = new LinkedList<>();
	}

	public void addEdge(int n, int m) {
		adjacencyList[n].add(m);
		adjacencyList[m].add(n);
		numOfEdges++;
	}

	public int getNumOfVertices() {
		return numOfVertices;
	}

	public int getNumOfEdges() {
		return numOfEdges;
	}
	
	public LinkedList<Integer>[] getAdjacencyList() {
		return adjacencyList;
	}

}
