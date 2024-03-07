package algorithm.gready;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class maxMeet {

	public static ArrayList<Integer> meet(int N,int[]sTime,int[]eTime) {
		
		ArrayList<Integer>ans=new ArrayList<>();
		int[][] meeting=new int[N][3];
		for(int i=0;i<N;i++) {
			
			meeting[i][0]=i+1;
			meeting[i][1]=sTime[i];
			meeting[i][2]=eTime[i];
			
		}
		
		Arrays.sort(meeting,Comparator.comparingInt(o->o[2]));
		
		int cEnd=meeting[0][2];
		ans.add(meeting[0][0]);
		for(int i=1;i<meeting.length;i++) {
			if(meeting[i][1]>cEnd) {
				ans.add(meeting[i][0]);
				cEnd=meeting[i][2];
			}
			
		}
		Collections.sort(ans);
		return ans;
		
		
	}
	
	public static void main(String[] args)
	{

		// Starting time
		int s[] = { 1, 3, 0, 5, 8, 10 };

		// Finish time
		int f[] = { 2, 4, 6, 7, 9 , 11 };
		
		System.out.println(meet(6,s,f));
	}
}
