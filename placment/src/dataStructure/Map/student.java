package dataStructure.Map;
import java.util.Objects;
public class student implements Comparable<student> {
   public  String name;
   public  int roll;
	public student(String name,int roll) {
		this.name=name;
		this.roll=roll;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(roll);
		
	}
	@Override
	public boolean equals(Object that) {
		// TODO Auto-generated method stub
		//return super.equals(obj);
		if(this==that) return true;
		if(that==null||getClass()!=that.getClass()) return false;
		student s=(student) that;
		return roll==s.roll;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student{"+ "name='"+name + '\''+ ",rollno=" +roll+'}';				//super.//toString();
	}
	@Override
	public int compareTo(student that) {
		// TODO Auto-generated method stub
		
		return this.roll -that.roll ;
	}
	
}
