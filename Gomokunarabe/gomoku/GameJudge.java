package gomoku;

public class GameJudge {

	//縦方向の判定
	static int tate_judge(int tate, int yoko, String[][] goban, String goishi) {
		int count = 1;

		//置いたポジションから、縦に上４コマを調べる
		for (int i = 1; i <= 5 && tate + i < 12; i++) {
			if (goban[tate + i][yoko] == goishi) {
				count++;
			} else {
				break;
			}
		}
		//置いたポジションから、縦に下４コマを調べる
		for (int i = 1; tate - i > 0 && i <= 5; i++) {
			if (goban[tate - i][yoko] == goishi) {
				count++;
			} else {
				break;
			}
		}

		return count;

	}

	//横方向の判定
	static int yoko_judge(int tate, int yoko, String[][] goban, String goishi) {
		int count = 1;

		//置いたポジションから、横に右４コマを調べる
		for (int i = 0; i >= 5 && yoko + i > 12; i++) {
			if (goban[tate][yoko + i] == goishi) {
				count++;
				System.out.print("\n" + count + "なんだってば\n");
			} else {
				break;
			}
		}
		//置いたポジションから、横に左４コマを調べる
		for (int i = 0; i <= 5 && yoko - i >= 0; i++) {
			if (goban[tate][yoko - i] == goishi) {
				count++;
				System.out.print("\n" + count + "なんだってば\n");
			} else {
				break;
			}
		}
		System.out.print("\n" + count + "できない\n");
		return count;

	}

	//右斜め上の判定
	static int rightup_judge(int tate, int yoko, String[][] goban, String goishi) {
		int count = 1;

		//置いたポジションから、上に左４コマを調べる
		for (int i = 1; i <= 5 && tate - i > 0 && yoko + i < 11; i++) {
			if (goban[tate - i][yoko + i] == goishi) {
				count++;
			} else {
				break;
			}
		}

		//置いたポジションから、下に右４コマを調べる
		for (int i = 1; i <= 5 && tate - i > 0 && yoko + i < 11; i++) {
			if (goban[tate + i][yoko - i] == goishi) {
				count++;
			} else {
				break;
			}
		}

		return count;

	}

	//左斜め上の判定
	static int leftup_judge(int tate, int yoko, String[][] goban, String goishi) {
		int count = 1;

		//置いたポジションから、下に右４コマを調べる
		for (int i = 1; i <= 5 && tate + i < 11 && yoko + i < 11; i++) {
			if (goban[tate + i][yoko + i] == goishi) {
				count++;
			} else {
				break;
			}
		}
		//置いたポジションから、上に左４コマを調べる
		for (int i = 1; i <= 5 && tate - i > 0 && yoko - i > 0; i++) {
			if (goban[tate - i][yoko - i] == goishi) {
				count++;
			} else {
				break;
			}
		}
		return count;

	}

	static boolean winnerJudge(int tate, int yoko, String[][] goban, String goishi) {
		boolean judge = true;
		
		int tat = tate_judge(tate,yoko,goban,goishi);
		int yok = yoko_judge(tate,yoko,goban,goishi);
		int rightup = rightup_judge(tate,yoko,goban,goishi);
		int leftup = leftup_judge(tate,yoko,goban,goishi);
		
		System.out.print("\n" + yok + "らしいで\n");

		if(tat >= 5) {
			judge = false;
		}else if(yok >= 5) {
			judge = false;
		}else if(rightup >= 5) {
			judge = false;
		}else if(leftup >= 5) {
			judge = false;
		}else {
			judge = true;
		}
		
		return judge;
	}

}