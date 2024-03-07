package DynamicPro;

public class wildcardMatching {
	int solve(String pattern, String str, int i, int j) {
		if (i < 0 && j < 0)
			return 1;
		if (i < 0 && j >= 0)
			return 0;
		if (i >= 0 && j < 0) {
			for (int k = 0; k <= i; k++) {
				if (pattern.charAt(k) != '*') {
					return 0;
				}
			}
			return 1;
		}
		if (pattern.charAt(i) == str.charAt(j) || pattern.charAt(i) == '?') {
			return solve(pattern, str, i - 1, j - 1);
		} else if (pattern.charAt(i) == '*') {
			return (solve(pattern, str, i - 1, j) | solve(pattern, str, i, j - 1));
		} else {
			return 0;
		}
	}

	int solveM(String pattern, String str, int i, int j, Integer[][] dp) {
		if (i < 0 && j < 0)
			return 1;
		if (i < 0 && j >= 0)
			return 0;
		if (i >= 0 && j < 0) {
			for (int k = 0; k <= i; k++) {
				if (pattern.charAt(k) != '*') {
					return 0;
				}
			}
			return 1;
		}
		if (dp[i][j] != null)
			return dp[i][j];
		if (pattern.charAt(i) == str.charAt(j) || pattern.charAt(i) == '?') {
			return dp[i][j] = solveM(pattern, str, i - 1, j - 1, dp);
		} else if (pattern.charAt(i) == '*') {
			return dp[i][j] = (solveM(pattern, str, i - 1, j, dp) | solveM(pattern, str, i, j - 1, dp));
		} else {
			return 0;
		}
	}

	int wildCard(String pattern, String str) {
		int i = pattern.length();
		int j = str.length();
		// Your code goes here
		Integer[][] dp = new Integer[i + 1][j + 1];
		return solveM(pattern, str, i - 1, j - 1, dp); 
	}
}
