package gomoku;

import java.util.Scanner;

public class GamePlay {

	//碁盤を表示するメソッド
	static void printGoban(String[][] goban) { 

		for (int tate = 0; tate <  goban.length; tate++) {
			for (int yoko = 0; yoko <  goban[tate].length; yoko++) {
				System.out.print(" " +  goban[tate][yoko]);
			}
			System.out.println();
		}
	}

	//取り込んだ数字が0-9の間かどうか判断する
	static int scn_checker(String jiku, int scn_no) {
		Scanner stdIn = new Scanner(System.in);

		while (0 > scn_no || scn_no > 9) {
			System.out.println("0～9の数字でお願いします。( ﾟДﾟ)))\n");
			System.out.print(jiku + "軸座標を入力してください\n>");
			scn_no = stdIn.nextInt();
		}
		return scn_no;
	}

	//碁盤に空きがあるかを確認するメソッド
	static boolean goban_place(String[][] goban) {

		boolean place = true;
		int place_count = 0;
		
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {

				if (goban[i][j] == "・") {
					place_count++;
				}
			}
		}
		if(place_count != 0) {
			place = true;
		}else {
			place = false;
		}
		return place;
	}

	static void setGoishi(String[][] goban, String[] goishi, String[] jiku) {
		Scanner stdIn = new Scanner(System.in);
		int i = 0;
		boolean nullplace = true;
		

		while (nullplace) {
			System.out.println(goishi[i % 2] + "の番です");
			System.out.print("縦軸座標を入力してください\n>");
			int tate = stdIn.nextInt();
			tate = scn_checker(jiku[0], tate); //取り込んだ数字が0-9の間かどうか判断するメソッド

			System.out.println();
			System.out.print("横軸座標を入力してください\n>");

			int yoko = stdIn.nextInt();
			yoko = scn_checker(jiku[1], yoko); //取り込んだ数字が0-9の間かどうか判断するメソッド

			//碁石が置かれているかどうかを判断するif文。
			if (goban[tate + 1][yoko + 1] == "・") {

				//碁石が置かれていなければ、碁盤配列へ格納する。
				goban[tate + 1][yoko + 1] = goishi[i % 2];
			} else {

				//すでに碁石が置かれていた場合はcontinueで、if文以下の処理を無視して繰り返す。
				//i++されないので、同じ碁石の人が置き場所を選ぶことが出来る。
				System.out.print("そこは既に石が置かれているよ！！( ;∀;)\n");
				continue;
			}

			printGoban(goban); //碁盤の表示
			nullplace = goban_place(goban);//碁盤に空きがあるかを確認するメソッド
			if(nullplace == false) {
				System.out.print("\n碁盤がうまっちゃった！\n引き分け！！( *´艸｀)\n");
			}
			
			GameJudge.yoko_judge(tate,yoko,goban,goishi[i % 2]);

			i++;
		}
		
	}
}
