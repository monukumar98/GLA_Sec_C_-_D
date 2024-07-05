package Lec7;

public class Distinct_Subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// string s--> coin t--> amount , i--> s ,j-->t
	public static int Subsequences(String s, String t, int i, int j) {
		if (j == t.length()) {// amount
			return 1;
		}
		if (i == s.length()) {// coin
			return 0;
		}

		int inc = 0;
		int exc = 0;
		if (s.charAt(i) == t.charAt(j)) {
			inc = Subsequences(s, t, i + 1, j + 1);
		}
		exc = Subsequences(s, t, i + 1, j);
		return inc + exc;

	}

}
