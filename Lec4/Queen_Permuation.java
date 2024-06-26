package Lec4;

public class Queen_Permuation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] board = new boolean[4];
		int tq = 2;
		Print(board, tq, "", 0);

	}

	public static void Print(boolean[] board, int tq, String ans, int qpsf) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < board.length; i++) {
			if (board[i] == false) {
				board[i] = true;
				Print(board, tq, ans + "b" + i + "q" + qpsf, qpsf + 1);
				board[i] = false;// Un-do
			}

		}

	}
}
