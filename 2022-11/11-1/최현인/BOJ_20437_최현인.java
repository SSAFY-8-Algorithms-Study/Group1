package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// 20437 문자열 게임2
// 문자열에서 찾는 문자가 나오면 큐에 넣고 카운트를 증가시키다가 카운트가 K와 같아질 때 최소길이와 최대 길이를 갱신
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			char[] W = br.readLine().toCharArray();
			int K = Integer.parseInt(br.readLine());
			
			ArrayDeque<Integer> q;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < 26; j++) {
				char c = (char)((int)'a' + j);
				q = new ArrayDeque<>();
				int count = 0;
				for (int k = 0; k < W.length; k++) {
					if (W[k] == c) {
						count++;
						q.add(k);
						if (count == K) {
							int idx = q.poll();
							int nowLen = k - idx + 1;
							min = Math.min(min, nowLen);
							max = Math.max(max, nowLen);
							
							count--;
						}
					}
				}
						
			}
			if (min == Integer.MAX_VALUE) {
				System.out.println(-1);
			}
			else {
				System.out.println(min+" "+max);
			}
		}
	}
}