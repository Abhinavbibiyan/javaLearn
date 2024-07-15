package string;

public class anagramofstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String a="aabb" ;        //"cat" ;                 //  abb,   bba,,,,bab,,
	    String b= "abab" ;        //"act";                 //
	    boolean isang= false;
	    boolean visited[] = new boolean[b.length()];
	    if(a.length()==b.length())
	    {
	       for(int i=0;i<a.length();i++)
	        {  
	    	char c = a.charAt(i);
	    	  isang =false;
	          for(int j=0;j<b.length();j++) 
	          { 
	        	  if(b.charAt(j)==c && !visited[j])
	        	  {
	        		  visited[j] =true;
	        		  isang=true;
	        		  break;
	        		  
	        	  } 
	           }
	          if(!isang)
	        	  break;
	         }
	    }
	    
	    if(isang) 
	    	System.out.println("anagram");
	    else
	    	System.out.println("not anagram");
	    
	
	}

    }

