package array;

public class Stock1 {
	public static int maxProFit(int [] price) {//O(n) O{
		int n=price.length;
		int profit=0;
		for(int i=1;i<n;i++) {
			if(price[i-1]<price[i]) 
			profit+= price[i]-price[i-1];
		}
				
		return profit;
	}
  
	public static int maxProfit(int [] price) {//O(n) O(1)
		int n=price.length;
		int profit=0;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			if(min >price[i]) min=price[i]; 
			profit=Math.max(profit, price[i]-min);
		}
				
		return profit;
	}
	public static void main(String[] args) {
		int [] price= {7,1,5,3,6,4};
		System.out.println(maxProfit(price));
		System.out.println(maxProFit(price));
	}
}
