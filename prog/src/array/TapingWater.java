package array;
import java.util.*;
public class TapingWater {
	public int WaterPointer(int[] height) {
		int water=0;
		int i=0,j=height.length-1,maxLeft=0,maxRight=0;
		while(i<j) {
			if(height[i]<=height[j]) {
				maxLeft=Math.max(maxLeft, height[i]);
				water+=maxLeft-height[i];
				i++;
				 
			}else {
				maxRight=Math.max(maxRight, height[j]);
				water+=maxRight-height[j];
				j--;
			}
		}
		return water;
	}
	public int WaterStack(int[] height) {
		int water=0,i=0;
		int n=height.length;
		
		Stack<Integer> st=new Stack<>();
		while(i<n) {
			while(!st.isEmpty() && height[st.peek()] < height[i]) {
				int right=st.pop();
				if(!st.isEmpty()) {
					int dis=i-1-st.peek();
					water+=dis*Math.min(height[st.peek()]-height[right], height[i]);
				}
			}
			
			st.push(i++);
			 
			
		}
		return water;
		
	}
	public int Water(int[] height) {
		int water=0;
		int n=height.length;
		int leftMax[]=new int[n];
		int rightMax[]=new int[n];
		for(int i=0;i<n;i++) {
			if(i==0) {
				leftMax[i]=height[0];
				rightMax[n-1]=height[n-1];
				
			}else {
				leftMax[i]=Math.max(leftMax[i-1], height[i]);
				rightMax[n-i-1]=Math.max(rightMax[n-i], height[n-i-1]);
			}
			
		}
		for(int i=0;i<n;i++) {
			water+=Math.min( leftMax[i], rightMax[i])-height[i];
		}
		
		return water;
		
	}
	public static void main(String[] args) {
		int[] height= {0,1,0,2,1,0,1,3,2,1,2,1};
		TapingWater tp=new TapingWater();
		System.out.println(tp.WaterStack(height));
		System.out.println(tp.Water(height));
		System.out.println(tp.WaterPointer(height));
		
	}

}
