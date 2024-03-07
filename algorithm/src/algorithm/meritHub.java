package algorithm;

/*
Mr. Arun Kumar S/o Mr. Suraj Kumar has purchased 10 acres of land in 20000000.
Mr. Amit Kumar S/o Mr. Arun kumar has purchased 15 acres of land in 25000000.
Mr. Ram Kumar S/o Mr. Arun kumar and Mr. Amit Kumar S/o Mr. Arun kumar have purchased 20 acres of land in 30000000.
Mrs. Anjali Devi W/o  Mr. Amit Kumar has purchased 12 acres of land in 15000000.
Mr. Manish Kumar S/o Mrs.  Anjali Devi  has purchased 17 acres of land in 17000000.
Mr. Manish Kumar S/o Mr. Amit Kumar and Ms. Priya D/o Mrs.  Anjali Devi  have purchased 20 acres of land in 19000000.

-------------------------------------------------------------------------------------------------------------------

Parse the above statements and store them in any data structure. The program should work with any number of statements and any name, land, or amount.

Your program should take the following input and calculate accordingly: 

Select * from LR where name = ‘Arun Kumar’
Select Sum(Land)  from LR where name = ‘Amit Kumar’
Select Sum(Amount)  from LR where name = ‘ Anjali Devi’

FamilyTree = Self +Spouse +  Descendant

Select * from LR where FamilyTree = ‘Amit Kumar’
Select Sum(Land)  from LR where FamilyTree = Suraj Kumar’
Select Sum(Amount)  from LR where FamilyTree = ‘Arun Kumar’

*/

public class meritHub {

	
	public static void main(String[] args) {
		
		String str1 = new String("Mr. Arun Kumar S/o Mr. Suraj Kumar has purchased 10 acres of land in 20000000.");
        String str2= new String("Mr. Amit Kumar S/o Mr. Arun kumar has purchased 15 acres of land in 25000000.");
        String str3= new String("Mr. Ram Kumar S/o Mr. Arun kumar and Mr. Amit Kumar S/o Mr. Arun kumar have purchased 20 acres of land in 30000000.");
        String str4= new String("Mrs. Anjali Devi W/o  Mr. Amit Kumar has purchased 12 acres of land in 15000000.");
        String str5= new String("Mr. Manish Kumar S/o Mrs.  Anjali Devi  has purchased 17 acres of land in 17000000.");
        String str6= new String("Mr. Manish Kumar S/o Mr. Amit Kumar and Ms. Priya D/o Mrs.  Anjali Devi  have purchased 20 acres of land in 19000000.");
        
//		String delimSpaceName = "and"||"has"||"have" ;
//		String[] name  = str3.split(delimSpaceName);
		String Amount=str3.substring(str3.length()-9, str3.length()-1);
		String fname=str3.substring(str3.indexOf("S/o")+4,str3.indexOf("has"));
//		System.out.println(name[0]);
		
		System.out.println(Amount);
		System.out.println(fname);
	}
}
