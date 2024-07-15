package learn;

public class DifferenceChar {
	public static char findTheDifference(String s, String t) {
        char c = 0;
        for(char cs : s.toCharArray()) c ^= cs;
        for(char ct : t.toCharArray()) c ^= ct;
        return c;
    }
	public static void main(String[] args) {
		String s = "abcd", t = "abcde";
		System.out.println(findTheDifference(s,t));
	}
}
