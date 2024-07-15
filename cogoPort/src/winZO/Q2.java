package winZO;
import java.util.*;
public class Q2 {
	public static void main(String[] args) {
        final int MOD = 1000000007;
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] cases = new int[T];
        int maxN = 0;
        for (int i = 0; i < T; i++) {
            cases[i] = sc.nextInt();
            if (cases[i] > maxN) {
                maxN = cases[i];
            }
        }

        long[] dp = new long[maxN + 3]; dp[0] = 1; dp[1] = 2; dp[2] = 5;
        for (int i = 3; i < maxN; i ++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % 1000000007;
        }
//        return (int)dp[maxN - 1];

        for (int i = 0; i < T; i++) {
            System.out.println(dp[cases[i]]);
        }

        sc.close();
	}
}
