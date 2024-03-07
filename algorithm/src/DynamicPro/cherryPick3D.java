package DynamicPro;

public class cherryPick3D {
	static int solve(int i, int j1, int j2, int r, int c, int[][] grid) {
		if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c)
			return (int) -1e7;
		if (i == r - 1) {
			if (j1 == j2)
				return grid[i][j1];
			else
				return grid[i][j1] + grid[i][j2];
		}
		int ans = -1000000;
		for (int dj1 = -1; dj1 <= 1; dj1++) {
			for (int dj2 = -1; dj2 <= 1; dj2++) {
				int max = 0;
				if (j1 == j2)
					max = grid[i][j1];
				else
					max = grid[i][j1] + grid[i][j2];
				max += solve(i + 1, j1 + dj1, j2 + dj2, r, c, grid);
				ans = Math.max(ans, max);
			}
		}
		return ans;
	}

	static int solve1(int i, int j1, int j2, int r, int c, int[][] grid, Integer[][][] dp) {
		if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c)
			return (int) -1e7;
		if (i == r - 1) {
			if (j1 == j2)
				return grid[i][j1];
			else
				return grid[i][j1] + grid[i][j2];
		}
		if (dp[i][j1][j2] != null)
			return dp[i][j1][j2];
		int ans = -1000000;
		for (int dj1 = -1; dj1 <= 1; dj1++) {
			for (int dj2 = -1; dj2 <= 1; dj2++) {
				int max = 0;
				if (j1 == j2)
					max = grid[i][j1];
				else
					max = grid[i][j1] + grid[i][j2];
				max += solve1(i + 1, j1 + dj1, j2 + dj2, r, c, grid, dp);
				ans = Math.max(ans, max);
				dp[i][j1][j2] = ans;
			}
		}
		return dp[i][j1][j2];
	}
	static int  solve2(int n,int m,int[][]grid){
        int[][][]dp=new int[n][m][m];
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2) dp[n-1][j1][j2]=grid[n-1][j1];
                else
                    dp[n-1][j1][j2]=grid[n-1][j1]+grid[n-1][j2];
            }
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int ans=-1000000;
                   for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int max=0;
                            if(j1==j2) max=grid[i][j1];
                            else
                                max=grid[i][j1]+grid[i][j2];
                            if(j1+dj1>=0 && j1+dj1<m && j2+dj2>=0 && j2+dj2<m){    
                                max+=dp[i+1][j1+dj1][j2+dj2]; 
                            }else    
                                max+=-1e8;
                            ans=Math.max(ans,max); 
                        }  
                    }
                   dp[i][j1][j2]=ans;          
                }
            }
        }
        return dp[0][0][m-1];
    }
	static int  solve3(int n,int m,int[][]grid){
        int[][] pre=new int[m][m];
        int[][] cur=new int[m][m];
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2) 
                    pre[j1][j2]=grid[n-1][j1];
                else
                    pre[j1][j2]=grid[n-1][j1]+grid[n-1][j2];
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int ans=-1000000;
                    for(int dj1=-1;dj1<=1;dj1++){
                        for(int dj2=-1;dj2<=1;dj2++){
                            int max=0;
                            if(j1==j2) max=grid[i][j1];
                            else
                                max=grid[i][j1]+grid[i][j2];
                            if(j1+dj1>=0 && j1+dj1<m && j2+dj2>=0 && j2+dj2<m){    
                                max+=pre[j1+dj1][j2+dj2]; 
                            }else    
                                max+=(int)-1e8;
                            ans=Math.max(ans,max); 
                        }  
                    }
                   cur[j1][j2]=ans;   
                }
            }
//            pre=cur;       
            for (int a = 0; a < m; a++) {
                pre[a] = (int[])(cur[a].clone());  
            } 
        }
        return pre[0][m-1];
    }

	public static int cherryPickup(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		int i = 0;
		int j1 = 0;
		int j2 = c - 1;
//		return solve(i, j1, j2, r, c, grid);
//        Integer[][][] dp=new Integer[r][c][c];
//        return solve1(i,j1,j2,r,c,grid,dp);
        return solve3(r,c,grid);
	}
	public static void print(int n) {
		if(n<=0) {
			System.out.println();
			return ;
			}
		System.out.print(n+" "); 
		print(n-1);
		System.out.print(n+" "); 
	}
	public static void main(String[] args) {
    	int[][]grid =
    			{{1,0,0,0,0,0,1},{2,0,0,0,0,3,0},{2,0,9,0,0,0,0},{0,3,0,5,4,0,0},{1,0,2,3,0,0,6}};
    	int[][]grid1 =
    					{{16,1,9,16,5,16,3,16,6,3,1,7},		{10,0,0,12,9,12,19,3,9,3,18,9},
    					{18,6,6,13,2,1,9,8,12,2,10,6},	   {16,7,6,10,5,17,16,0,12,7,5,15},
    					{20,11,17,15,2,8,12,2,17,13,12,0},{11,1,10,11,13,9,16,7,1,12,13,8},
    					{12,19,19,3,13,0,7,1,1,3,1,16},		 {4,9,1,4,16,19,11,11,3,9,2,7},
    					{10,13,1,4,3,7,14,3,20,7,6,11},  {8,17,14,13,2,5,9,11,11,18,19,15},
    					{16,4,3,13,18,17,14,16,15,12,20,13},{20,0,19,16,0,3,16,16,1,15,2,20},
    					{20,18,8,11,0,13,8,7,13,6,18,19},   {9,2,9,18,10,16,0,5,9,11,4,14},
      					{11,4,18,8,18,18,10,12,11,0,10,13}    ,{0,7,9,2,1,17,4,1,6,9,7,9}};
    					
//    			System.out.println(cherryPickup(grid));
//				System.out.println(cherryPickup(grid1));
				print(5);
		}	
}
