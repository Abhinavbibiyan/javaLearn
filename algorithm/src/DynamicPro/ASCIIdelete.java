package DynamicPro;
import java.util.*;
public class ASCIIdelete {
	public static int[] solveQueries(int[] nums, int[][] Queries, int k)
    {
        ArrayList<Integer>arr=new ArrayList<>();
       
        Set<String> set=new HashSet<String>();
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<Queries.length;i++){
        int l=Queries[i][0];
        int r=Queries[i][1];
        int count=0;
       
        for (int j=l; j<=r; j++)
           {
            mp.put(nums[j-1], mp.get(nums[j-1]) == null ? 1 : mp.get(nums[j-1]) + 1);
            }
             for (int kk = l; kk <=r; kk++)
             {
               if (mp.get(nums[kk-1])>= k)
               {   String ss=nums[kk-1]+"";
                   if(!set.contains(ss))
                   {
                       count++;
                       set.add(ss);
                   }
               
               }

             }
           set.clear();
                             
           mp.clear();
           arr.add(count);
       }    
       int []arr1=new int[arr.size()];
       for(int i=0;i<arr.size();i++)
       arr1[i]=arr.get(i);
       return arr1;
    }
	public static void main(String[] args) {
		int[]nums = {1,1,2,1,3};
		int[][]Queries = {{1,5},
				{2,4}};
		int k = 1;
		int[]ans=solveQueries(nums,Queries,k);
		for(int e:ans) System.out.println(e);
		
	}
}
