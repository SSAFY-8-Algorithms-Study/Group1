import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int under;
	static long answer;
	static String input;
	static int[] select;
	static boolean LCHK;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		under = 0;
		LCHK = false;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '_') {
				under++;
			}
			if (input.charAt(i) == 'L') {
				LCHK = true;
			}
		}

		select = new int[under];
		answer = 0;
		permutation(0);
		System.out.println(answer);
	}

	static void permutation(int cnt) {
		boolean local_LCHK = LCHK;
		if (cnt == under) {
			int con = 0;
			int vowel = 0;
			long temp = 1;
			for (int i = 0, ui = 0; i < input.length(); i++) {
				if (input.charAt(i) == '_') {
					if (select[ui] == 0) { // 0이면 자음 - L
						if (con > 1) {
							return;
						}
						temp *= 20;
						con++;
						vowel = 0;
					} else if(select[ui] == 1) { // 1이면 모음
						if (vowel > 1) {
							return;
						}
						temp *= 5;
						vowel++;
						con = 0;
					}else { // 2면 L
						local_LCHK = true;
						if(con > 1) {
							return;
						}
						con++;
						vowel = 0;
					}
					ui++;
				} else { // 밑줄 아님
					if (input.charAt(i) == 'A' || input.charAt(i) == 'E' || input.charAt(i) == 'I'
							|| input.charAt(i) == 'O' || input.charAt(i) == 'U') {
						if (vowel > 1) {
							return;
						}
						vowel++;
						con = 0;
					} else {
						if (con > 1) {
							return;
						}
						con++;
						vowel = 0;
					}
				}
			}

			if (local_LCHK) {
				answer += temp;
			} else {
				return;
			}
//			System.out.println(Arrays.toString(select));
//			System.out.println(answer);
			return;
		}
		// 0 : 자음-L, 1 : 모음, 2 : L
		for (int i = 0; i < 3; i++) {
			select[cnt] = i;
			permutation(cnt + 1);
		}
	}
}
