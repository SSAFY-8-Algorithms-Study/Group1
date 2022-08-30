import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[] cipher = { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010" };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String input = br.readLine();
		int chk = -1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String sub = input.substring(i * 6, 6 * (i + 1));
			int idx = check(sub);
			if (idx < 0) {
				chk = i;
				break;
			} else {
				char ch = (char) (idx + 'A');
				sb.append(ch);
			}
		}
		if (chk == -1) {
			System.out.println(sb.toString());
		} else {
			System.out.println(chk + 1);
		}

	}

	static int check(String str) {
		int min_cnt = Integer.MAX_VALUE;
		int min_idx = -1;
		for (int i = 0; i < 8; i++) {
			int temp = different(str, cipher[i]);
			if (temp < min_cnt) {
				min_cnt = temp;
				min_idx = i;
			}
		}
		if (min_cnt < 2) {
			return min_idx;
		} else {
			return -1;
		}
	}

	static int different(String a, String b) {
		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			char ach = a.charAt(i);
			char bch = b.charAt(i);
			if (ach != bch) {
				cnt++;
			}
		}
		return cnt;
	}

}