import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int[] alpha = new int[26];
		for (int i = 0; i < input.length(); i++) {
			alpha[input.charAt(i) - 'A']++;
		}
		boolean odd = false;
		for (int i = 0; i < 26; i++) {
			if (alpha[i] % 2 != 0) {
				if (!odd) {
					odd = true;
				} else {
					System.out.println("I'm Sorry Hansoo");
					System.exit(0);
				}
			}
		}

		String middle = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 26; i++) {
			if (alpha[i] == 0) {
				continue;
			}
			for (int j = 0; j < alpha[i] / 2; j++) {
				sb.append((char) ('A' + i));
			}
			if (alpha[i] % 2 != 0) {
				middle = (char) ('A' + i) + "";
			}
		}
		System.out.println(sb.toString() + middle + sb.reverse().toString());

	}

}