package Lec4;

public class Kye_Paid {
	static String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "27";

	}

	public static void Print(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);// 50
		String p = key[ch - 48];// abc
		for (int i = 0; i < p.length(); i++) {
			Print(ques.substring(1), ans + p.charAt(i));
		}
	}

}
