package NAB;

import java.util.Arrays;

public class secQue {
	public static int solution(String S) {
        // Implement your solution here
        int n=S.length();
        int count=0;
        // Stack<Character> s=new Stack<Character>();
        Boolean clear[]=new Boolean[n];
        Arrays.fill(clear,false);
        Boolean flag=false;
        if(S.charAt(0)=='<'){
            // clear[0]=true;
            flag=true;
        }
        for(int i=0;i<n;i++){
            if(S.charAt(i)=='v'){
                clear[i]=true;
            }else if(S.charAt(i)=='^'){
                clear[i]=true;
            }
            else if((S.charAt(i)=='>' && i!=n-1)){
                flag=false;
                clear[i]=false;
            }
            else if((S.charAt(i)=='>' && i==n-1)){
                clear[i]=true;
            }
            else if(S.charAt(i)=='<'&& flag==true){
                clear[i]=true;
            }else if(S.charAt(i)=='<'&& flag==false){
                clear[i]=false;
            }          
        }
        for(int i=0;i<n;i++){
            if(clear[i]){
                count++;
            }
        }
        return count;
        // if(S.charAt(n-1)=='>'||S.charAt(n-1)=='^'||S.charAt(n-1)=='V')
        //     return count+1;
        // else{
        //     return count;
        // }    
        // if(S.charAt(0)=='<'||S.charAt(0)=='^'||S.charAt(0)=='V')
        //     count=1;
        // s.push(S.charAt(0));
        // for(int i=1;i<S.length();i++){
        //     if(!(S.charAt(i)=='<' && s.peek()=='>')){
        //         count++;
        //     }
        //     else if(!(S.charAt(i)=='>' && s.peek()=='<')){
        //         count++;
        //     }
        //     else{
        //         count++;
                
        //     }
        //     s.push(S.charAt(i));
        // }
        // return count;
    }
	public static void main(String[] args) {
		System.out.println(solution("<<^<v>>"));
	}
}
