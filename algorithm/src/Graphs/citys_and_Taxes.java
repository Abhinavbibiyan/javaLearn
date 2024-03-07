package Graphs;
import java.util.*;

public class citys_and_Taxes {
    
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int[][] dp;
    static int[] tax;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println(" Input the number of cities and the roads");
        int n = sc.nextInt();
        int[][] roads = new int[n-1][2];
        for (int i = 0; i < n-1; i++) {
            roads[i][0] = sc.nextInt()-1;
            roads[i][1] = sc.nextInt()-1;
        }
        
        // Create an adjacency list for the cities
        adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n-1; i++) {
            adjList[roads[i][0]].add(roads[i][1]);
            adjList[roads[i][1]].add(roads[i][0]);
        }
        
        System.out.println("Input the taxes for each city");
        tax = new int[n];
        for (int i = 0; i < n; i++) {
            tax[i] = sc.nextInt();
        }
        
        System.out.println("// Input the trips and calculate the minimum sum of taxes for each trip");
        int m = sc.nextInt();
        int[] tripTax = new int[m];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            dp = new int[n][2];
            visited = new boolean[n];
            dfs(u, -1);
            tripTax[i] = dp[u][0] + dp[u][1] + tax[u];
            dp = new int[n][2];
            visited = new boolean[n];
            dfs(v, -1);
            tripTax[i] += dp[v][0] + dp[v][1] + tax[v];
        }
        
        // Sort the trip taxes in increasing order and calculate the minimum sum of taxes for all trips
        Arrays.sort(tripTax);
        int minSum = 0;
        for (int i = 0; i < m/2; i++) {
            minSum += tripTax[i]/2;
        }
        for (int i = m/2; i < m; i++) {
            minSum += tripTax[i];
        }
        
        // Output the minimum sum of taxes
        System.out.println(minSum);
    }
    
    // Perform a depth-first search to calculate the minimum sum of taxes for each city
    static void dfs(int u, int parent) {
        visited[u] = true;
        dp[u][0] = 0;
        dp[u][1] = tax[u];
        for (int v : adjList[u]) {
            if (v == parent) {
                continue;
            }
            if (!visited[v]) {
                dfs(v, u);
                dp[u][0] += dp[v][1];
                dp[u][1] += Math.min(dp[v][0], dp[v][1]);
            }
        }
    }

}
