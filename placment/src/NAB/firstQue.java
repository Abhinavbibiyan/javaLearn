package NAB;
import java.util.*;
public class firstQue {
	public int solution(String S) {
        // Implement your solution here
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<S.length();i++){
//            map.put(S.charAt(i),((HashMap<Character, Integer>) map).getOrDefault(S.charAt(i),0)+1);
            map.getOrDefault(map, null);
            
        }
        // for(Map.Entry<Character,Integer> m:map.entrySet()){
        //     if(m.getKey()=='B')
        // }
        int b=map.get('B');
        int a=map.get('A');
        int n=map.get('N');
        return Math.min(b/1,Math.min(a/3,n/2));

    }
	public static void main(String[] args) {
		int n=5;
		for(int i=0;i<n;i++) {
			for(int j=0;j<i+1;j++) {
				int x=0;
				for(int k=0;k<j;k++) {
					x=x+n-k;
					
				}
				if(j%2==0)
				{			
					System.out.print(x+i-j+1 +" ");
				}
				else {
					System.out.print(x+n-i +" ");
				}
			}
			System.out.println();
		}
		
	}

}
