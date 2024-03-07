package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trilogy_graph {

	    static int INF = 1000000000;

	    public int minimizeTaxes(int A, int[][] B, int[][] C, int[] D) {
	        // Create an adjacency list to represent the graph
	        List<List<Integer>> adjList = new ArrayList<>();
	        for (int i = 0; i < A; i++) {
	            adjList.add(new ArrayList<>());
	        }
	        for (int i = 0; i < B.length; i++) {
	            int u = B[i][0] - 1;
	            int v = B[i][1] - 1;
	            adjList.get(u).add(v);
	            adjList.get(v).add(u);
	        }

	        // Create a 2D array to store the minimum taxes for each pair of cities
	        int[][] dp = new int[A][3];
	        for (int i = 0; i < A; i++) {
	            Arrays.fill(dp[i], INF);
	        }

	        // Use dynamic programming to compute the minimum taxes for each pair of cities
	        computeTaxes(adjList, dp, D, 0, -1);

	        // Compute the minimum sum of taxes for all the C trips
	        int minTaxes = 0;
	        for (int i = 0; i < C.length; i++) {
	            int u = C[i][0] - 1;
	            int v = C[i][1] - 1;
	            minTaxes += Math.min(dp[u][0] + dp[v][1], dp[u][1] + dp[v][0]);
	        }
	        return minTaxes;
	    }

	    // Use dynamic programming to compute the minimum taxes for each pair of cities
	    private void computeTaxes(List<List<Integer>> adjList, int[][] dp, int[] D, int u, int parent) {
	        dp[u][0] = 0;  // Minimum taxes for entering the city u
	        dp[u][1] = D[u];  // Minimum taxes for leaving the city u
	        dp[u][2] = D[u] / 2;  // Minimum taxes for making the tax of city u half

	        for (int v : adjList.get(u)) {
	            if (v != parent) {
	                computeTaxes(adjList, dp, D, v, u);
	                int min1 = Math.min(dp[u][0] + dp[v][1], dp[u][1] + dp[v][0]);
	                int min2 = Math.min(dp[u][0] + dp[v][2], dp[u][2] + dp[v][0]);
	                dp[u][0] = Math.min(dp[u][0] + dp[v][0], dp[u][1] + dp[v][1] + D[u]);
	                dp[u][1] = Math.min(dp[u][1] + dp[v][1], dp[u][0] + dp[v][0] + D[u]);
	                dp[u][2] = Math.min(dp[u][2] + dp[v][2], min1 + D[u] / 2);
	                dp[u][2] = Math.min(dp[u][2], min2);
	            }
	        }
	    }
	}
