package DynamicPro;

public class strangePainter {
	private static int[][] dp;

	private static int strangePrinter(final String s, int i, int j) {
		if (i > j)
			return 0;
		if (dp[i][j] > 0)
			return dp[i][j];
		dp[i][j] = strangePrinter(s, i + 1, j) + 1;
		for (int k = i + 1; k <= j; ++k)
			if (s.charAt(k) == s.charAt(i))
				dp[i][j] = Math.min(dp[i][j], strangePrinter(s, i, k - 1) + strangePrinter(s, k + 1, j));
		return dp[i][j];
	}

	public static int strangePrinter(String s) {
		final int n = s.length();
		dp = new int[n][n];
		return strangePrinter(s, 0, n - 1);
	}
	public static void main(String[] args) {
		String s = "aaabbb";
		System.out.println(strangePrinter(s));
	}
}
