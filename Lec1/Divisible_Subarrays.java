package Lec1;

public class Divisible_Subarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 6 };

	}

	public static long Count_Subarray(int[] arr) {
		long sum = 0;
		long[] freq = new long[arr.length];
		int n = arr.length;
		freq[0] = 1;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];// sum = sum + arr[i];
			int idx = (int) (sum % n);
			if (idx < 0) {
				idx += n;
			}
			freq[idx]++;// freq[idx]=freq[idx]+1;
		}
		long ans = 0;
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] >= 2) {
				long p = freq[i];
				ans = ans + (p * (p - 1)) / 2;
			}
		}
		return ans;

	}

}
