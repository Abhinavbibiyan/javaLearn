package DynamicPro;

import java.util.Arrays;

public class minCoin {
	public static int gameOfDeath(int n, int k) {
		if (n == 1)
			return 1;

		return (gameOfDeath(n - 1, k) + k) % n;
	}

	public static int minCoin(int n, int[] coin, int[] dp) {
		if (n == 0)

			return 0;
		int ans = Integer.MAX_VALUE;
		dp[0] = 0;
		int subAns = 0;
		if (coin.length == 1) {
			if ( n %coin[0] == 0) {

				return n/coin[0];
			} else
				return -1;
		} else {
		for (int i = 0; i < coin.length; i++) {
			if (n - coin[i] >= 0) {
				if (dp[n - coin[i]] != -1) {
					subAns = dp[n - coin[i]];
				} else {
					subAns = minCoin(n - coin[i], coin, dp);
				}
				if (subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
					ans = subAns + 1;
				}
			}
		}
		}
		return dp[n] = ans;
	}

	public static void main(String[] args) {
		int n = 15 ;
		int[] coin = { 3 };
		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		int ans = minCoin(n, coin, dp);
		System.out.println(ans);
		int i = 0;
		for (int e : dp)
			System.out.print(i++ + " -> " + e + "\n");
//		System.out.println(gameOfDeath(5,3));
	}
}
