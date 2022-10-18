package week10_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 행과 열을 기준으로 map을 탐색하면서 연속된 'ㅣ' 와 '-'의 개수를 카운팅한다.
 * */

public class BOJ_1388_백자민 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][];
		
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		int cnt = 0;
        for (int i=0;i<N;i++) {
            int tmp = 0;
            for (int j=0;j<M;j++) {
                if (map[i][j] == '|') {
                    tmp = 0;
                } else if (++tmp == 1) {
                    cnt++;
                }
            }
        }
        for (int j=0;j<M;j++) {
            int tmp = 0;
            for (int i=0;i<N;i++) {
                if (map[i][j] == '-') {
                    tmp = 0;
                } else if (++tmp == 1) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
	}
}
