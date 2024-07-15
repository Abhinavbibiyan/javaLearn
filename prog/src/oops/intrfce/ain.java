package oops.intrfce;

public class ain  implements printable{  
	
 int a =2 ;
	public void draw(){System.out.println("drawing rectangle 0");}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
		System.out.println("drawing rectangle 1");
	}

	@Override
	public void drawable() {
		// TODO Auto-generated method stub
		System.out.println("drawing rectangle 2");
	}  
	 
    
	}  


