//Program to find out the Area and perimeter of rectangle and box using super and this keyword
package learn;
  class rectangle{
       public int lenght;
        public int breath;
        rectangle(int lenght,int breath){
        lenght=this.lenght;
        breath=this.breath;
        }
        public void area(int length ,int breath ){
        System.out.println("area of the box of side length " + length +"and breath "+ breath  + " = "+length *breath );}
         public void perameter(int length ,int breath){
        System.out.println("parameter of the box of  length " + length +"and breath "+ breath  + " = "+2*(length + breath) );
         }
    }
    class box  extends rectangle{
    public float side;
    box(int lenght,int breath,float side){
        super(lenght,breath);
        side=this.side;
    }
        public  void area(int side){
        System.out.println("area of the box of side length " + side + " = "+ side*side);
    }
    public void perameter(int side){
        System.out.println("parameter of the box of side lengtgh "+ side + " is = "+ 4*side );
    }
}
public class ex10inherit {
      public static void main(String[] args) {
      box rect=new box(3,4,5.0f);
      rect.area(3, 4);
      rect.perameter(3, 4);
      box sq=new box(4,5,8);
      sq.area(8);
      sq.perameter(8);
          }         
}
