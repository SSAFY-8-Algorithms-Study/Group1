package boj2607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 비슷한 단어
 * 각 단어에 사용된 알파벳의 개수를 count한다.
 * 기준이 되는 단어 finput과 비교하는 단어 input의 길이 차이가 1보다 크다면 넘어간다. -> 비슷한 단어가 아님
 * chk 함수를 이용해 finput에 사용된 알파벳 개수와 input에 사용된 알파벳 개수를 비교한다.
 * 서로 다를 수 있는 경우는 2번이다. 그 이상 달라지면 false를 리턴한다.
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String finput = br.readLine();
		int[] first = count(finput);
		int ans = 0;
		for (int i = 0; i < N - 1; i++) {
			String input = br.readLine();
			if (Math.abs(finput.length() - input.length()) > 1)
				continue;
			int[] str = count(input);
			if(chk(first, str)) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	static int[] count(String str) {
		int[] cnt = new int[26];
		for (int i = 0; i < str.length(); i++) {
			cnt[str.charAt(i) - 'A']++;
		}
		return cnt;
	}

	static boolean chk(int[] f, int[] s) {
		boolean change1 = false;
		boolean change2 = false;
		for (int i = 0; i < 26; i++) {
			if (f[i] == s[i])
				continue;
			if (Math.abs(f[i] - s[i]) == 1) {
				if(!change1) {
					change1 = true;
				}else {
					if(!change2) {
						change2 = true;
					}else {
						return false;
					}
				}
			} else {
				return false;
			}
		}
		return true;
	}

}
