package array;

public class pageAllocation {
	public static int help(int []arr ,int n,int cap){
        int page=0;
        int student=1;
        
        for(int i=0;i<n;i++){
            if(page+arr[i]>cap){
                student++;
                page=arr[i];
            }else{
                page+=arr[i];
            }
        }
        return student;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        if(M>N) return -1;
        int l=0;
        int h=0;
        for(int e:A){
            l=Math.max(l,e);
            h+=e;
        }
        while(l<=h){
            int mid=(l+h)/2;
            int stud=help(A,N,mid);
            if(stud>M){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return l;
    }
    public static void main(String[] args) {
		int N = 3;
		int	A[] = {15,17,20};
		int M = 2;
		System.out.println(Integer.toBinaryString(-9));
		System.out.println(findPages(A,N,M));
		System.out.println((-9)%4);
	}
}
