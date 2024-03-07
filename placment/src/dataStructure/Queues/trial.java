package dataStructure.Queues;

import java.util.Collections;
import java.util.PriorityQueue;

public class trial {
	public static int solve(int[][] mat,int n,int m) {
		 int ans=0;
		 PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
		 PriorityQueue<Integer> minHeap=new PriorityQueue<>();
		 int i=0,j=0;
		 while(i<n) {
			 for(int a=0;a<m;a++) {
				 maxHeap.add(mat[i][a]);
				 
			 }
			 System.out.println(maxHeap);
			 for(int a=0;a<m;a++) {
				 if(i==n-1) {
					 minHeap.add(mat[0][a]);
				 }else
				 minHeap.add(mat[i+1][a]);
			 }
			 System.out.println(minHeap);
			 int temp=0;
			 while(!minHeap.isEmpty()) {
				 int max=maxHeap.poll();
				 int min=minHeap.poll();
			//  temp+=minHeap.poll()*maxHeap.poll();
				 temp+=min*max;
			 
			 }
			  System.out.println(temp);
			  System.out.println(minHeap);
			 
			 ans=Math.max(ans, temp);
			 i++;
			 
		 }
		 return ans;
	     
	}
	public static void main(String[] args) {
		int[][]mat= {{1,2,3},
				     {4,3,5},
				     {1,1,3},
				     {3,2,1}};
		System.out.println(solve(mat,4,3));
	}

}
