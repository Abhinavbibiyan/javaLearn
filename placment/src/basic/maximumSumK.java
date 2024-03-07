package basic;
import java.util.*;
public class maximumSumK {
	static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // List<Integer> list = new ArrayList<>();
        // List<Integer> ans = new ArrayList<>();
        // Arrays.sort(A);
        // Arrays.sort(B);
        
        // for(int i=0;i<K;i++){
        //     for(int j=0; j<K;j++){
        //         list.add(A[N-i-1]+B[N-j-1]);
        //     }
        // }
        // Collections.sort(list,Collections.reverseOrder());
        // for(int i=0;i<K;i++){
        //     ans.add(list.get(i));
        // }
        // return ans;
        PriorityQueue<Integer>p=new PriorityQueue<>();
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=N-1;i>=0;i--){
            for(int j=N-1;j>=0;j--){
                int t=A[i]+B[j];
                if(p.size()<K){
                    p.add(t);
                }
                else if(p.peek()<t){
                    p.poll();
                    p.add(t);
                }
                else{
                    break;
                }
            }
            
            
        }
        List<Integer>ans=new ArrayList<>();
        while(!p.isEmpty()){
            ans.add(p.poll());
        }
        Collections.sort(ans,Collections.reverseOrder());
        return ans;
        
    }
	public static void main(String[] args) {
		int N = 2;
		int	K = 2;
		int A [ ] = {3, 2};
		int	B [ ] = {1, 4};
		System.out.println(maxCombinations(N,K,A,B));
	}
}
