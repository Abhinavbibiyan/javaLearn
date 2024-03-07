package DynamicPro;
import java.util.*;
public class rectangleArea {
	public static int[] nextSmall(int n,int arr[]){
        int[] nex=new int[n];
        Stack<Integer>s=new Stack<>();
        s.push(-1);
        
        for(int i=n-1;i>=0;i--){
            int curr=arr[i];
            while(s.peek()!=-1 && curr <= arr[s.peek()]){
                s.pop();
            }
            nex[i]=s.peek();
            s.push(i);
        }
        return nex;
    }
    public static int[] preSmall(int n,int[] arr){
        int pre[]=new int[n];
        Stack<Integer> s=new Stack<>();
        s.push(-1);
        for(int i=0;i<n;i++){
            int curr=arr[i];
            while(!s.isEmpty() && s.peek()!=-1 && curr<= arr[s.peek()]){
                s.pop();
            }
            pre[i]=s.peek();
            s.push(i);
        }
        return pre;
    }
    public static int rectArea(int n,int[] arr){
        int nex[]=nextSmall(n,arr);
        int pre[]=preSmall(n,arr);
        
        int maxAns=Integer.MIN_VALUE;
        for(int i=0;i<n; i++){
            int h=arr[i];
            if(nex[i]==-1) {
                nex[i]=n;
            }
            int b=nex[i]-pre[i]-1;
            int area=h*b;
            maxAns=Math.max(area,maxAns);
        }
        return maxAns;
    }
    public static int maxArea(int M[][], int n, int m) {
         int[] heights = M[0];
        int area = rectArea(m,heights);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] != 0) {
                    M[i][j] += M[i - 1][j];
                } else {
                    M[i][j] = 0;
                }
            }
            area = Math.max(area, rectArea(m,M[i]));
        }
        return area;
        // add code here.
        // int dp[][]=new int[n][m];
        // int area=Integer.MIN_VALUE;
        // int height[]=new int[m];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(M[i][j]==0){
        //             height[j]=0;
        //         }else{
        //             height[j]++;
        //         }
        //     }
        //     int res=rectArea(m,height);
        //     area=Math.max(res,area);
        // }
        // return area;
        
    }
    public static void main(String[] args)
    {
        int R = 4;
        int C = 4;
 
        int A[][] = {
            { 0, 1, 1, 0 },
            { 1, 1, 1, 1 },
            { 1, 1, 1, 1 },
            { 1, 1, 0, 0 },
        };
        System.out.print("Area of maximum rectangle is "
                         + maxArea(A, C, R));
    }
}
