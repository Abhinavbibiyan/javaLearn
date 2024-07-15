package lists;

public class arrlist <X, Y> {
 
	
	X x;
	Y y;
	//public arrlist(String x,int y)
	
	public arrlist(X x,Y y)	   {
		this.x=x;
		this.y=y;
	}
	public void GetDescreption () {
		System.out.println(x  + " "+ y);
	}
 

} 
