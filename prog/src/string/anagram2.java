package string;

public class anagram2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String a="aabb@#^&&&$%" ;        //"cat" ;                 //  abb,   bba,,,,bab,,
		    String b= "abab&&&#^%$@" ;        //"act";                 //
		    boolean isang= true;
		    int [] al= new int[256];
		    int [] bl =new int[256];
		    for(char c: a.toCharArray()) {
		    	int index = (int) c;
		    	al[index]++;
		     
		    }
		    for(char c: b.toCharArray()) {
		    	int index = (int)c;
		    	bl[index]++;
		    	
		    }
            for(int i=0; i<256;i++) {
            	if(al[i]!=bl[i]) {
            		isang= false;
            		break;
            	}
            }
            if(isang)
            	System.out.println("anagram");
            else
            	System.out.println("not anagram");
		    
	}

}
