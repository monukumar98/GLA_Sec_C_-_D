package Lec8;

public class Longest_Increasing_Subsequence_N_Log_N {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };

	}

	public static int LIS(int[] arr) {

		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		int len = 1;
		for (int i = 1; i < dp.length; i++) {
			if (dp[len - 1] < arr[i]) {
				dp[len] = arr[i];
				len++;
			} else {
				int idx = BinarySearch(dp, 0, len, arr[i]);
				dp[idx] = arr[i];
			}
		}
		return len;
	}

	private static int BinarySearch(int[] dp, int lo, int hi, int item) {
		// TODO Auto-generated method stub
		int ans = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (dp[mid] >= item) {
				ans = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return ans;
	}

}
