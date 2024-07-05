package Lec8;

public class Wine_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wine = { 2, 3, 5, 1, 4 };
	}

	public static int maximum_profitBU(int[] wine) {
		int[][] dp = new int[wine.length][wine.length];
		int year = wine.length;
		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = wine[i] * year;
		}
		year--;
		for (int gap = 1; gap < dp.length; gap++) {
			for (int j = gap; j < dp.length; j++) {
				int i = j - gap;

				int fs = wine[i] * year + dp[i - 1][j];
				int ls = wine[j] * year + dp[i][j - 1];
				dp[i][j] = Math.max(fs, ls);
			}
			year--;
		}
		return dp[0][dp[0].length - 1];
	}

	public static int maximum_profit(int[] wine, int si, int ei, int year) {
		if (si > ei) {
			return 0;
		}

		int fs = wine[si] * year + maximum_profit(wine, si + 1, ei, year + 1);
		int ls = wine[ei] * year + maximum_profit(wine, si, ei - 1, year + 1);
		return Math.max(fs, ls);

	}
}
