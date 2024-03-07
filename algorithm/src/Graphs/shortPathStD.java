package Graphs;
import java.util.*;
class group{
    int first,second,third;
    group(int dis,int a,int b){
        first=dis;
        second=a;
        third=b;
    }
}
public class shortPathStD {
	    static int shortestDistance(int N, int M, int A[][], int X, int Y) {
	        if(A[0][0]!=1) return -1;
	        Queue<group> q=new LinkedList<>();
	        q.add(new group(0,0,0)); 
	        int ti[]={0,-1,1,0}; 
	        int tj[]={1,0,0,-1};
	        while(!q.isEmpty()){
	            group temp=q.poll();
	            int dis=temp.first,i=temp.second,j=temp.third;
	            if(i==X && j==Y) return dis;
	            for(int k=0;k<4;k++){
	                int newi=i+ti[k],newj=j+tj[k]; 
	                if(newi>=0 && newj>=0 && newi<N && newj<M && A[newi][newj]==1){
	                    A[newi][newj]=0;  
	                    q.add(new group(dis+1,newi,newj)); 
	                }
	            }
	        }
	        return -1;
	    }
	        
	public static void main(String[] args) {
		int N=3, M=4;
			int[][]	A= {{1,0,0,0}, 
				   {1,1,0,1},
				   {0,1,1,1}};
			int	X=2, Y=3 ;
		System.out.println(shortestDistance(N, M, A, X, Y));
	}

}
