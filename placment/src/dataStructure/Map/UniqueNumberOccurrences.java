package dataStructure.Map;
import java.util.*;
public class UniqueNumberOccurrences {
	public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int check=0;
        for(Object m:map.entrySet().toArray()){
//        	System.out.println(m.getKey()+" "+ m.getValue());
        	System.out.println(m);
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(check==m.getValue()){
                return false;
            }
            check=m.getValue();
        }
        return true;
        // Arrays.sort(arr);
        // HashSet<Integer> set=new HashSet<>();
        // int count=1;
        // for(int i=1;i<arr.length;i++){
        //     if(arr[i]==arr[i-1]){
        //         count++;
        //     }else{
        //         if(set.contains(count)){
        //             return false;
        //         }
        //         set.add(count);
        //         count=1;
        //     }
        // }
        // if(set.contains(count)) return false;
        // return true;
	}
	public static void main(String[] args) {
		int[] arr ={26,2,16,16,5,5,26,2,5,20,20,5,2,20,2,2,20,2,16,20,16,17,16,2,16,20,26,16};
		Arrays.sort(arr);
		for(Object e: arr) {
			System.out.println(e);
		}
		System.out.println(uniqueOccurrences(arr));
		
	}
}
