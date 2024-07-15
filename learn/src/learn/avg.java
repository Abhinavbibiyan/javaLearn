//Program to get average of sum of number
package learn;
import java.util.Scanner;
//public class avg {
//    public static void main(String[] args) {
//        Scanner s= new Scanner(System.in);
//        int sum=0;
//           System.out.println("enter how many no you want to enter for avg :  ");
//            int n =s.nextInt();
//        for(int i=1;i<=n;i++){
//        System.out.println("enter " + i+"th no : ");
//        int no=s.nextInt();
//        sum+=no;
//        }
//        int avg=sum/n;
//        System.out.println("avg of "+n+"no is ="+avg);
//         }
//}

interface StudentRead{
    void read();
}
interface StudentWrite{
    void write();
}
class Std implements StudentRead, StudentWrite{
    public void read(){
        System.out.println("The students read.");
    }
    public void write(){
        System.out.println("The students write.");
    }
}
public class avg
{
  public static void main(String[] args) {
    Std s = new Std();
    s.read();
    s.write();
  }
}

