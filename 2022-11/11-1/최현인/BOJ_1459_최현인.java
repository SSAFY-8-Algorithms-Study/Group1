package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1459 걷기
// 조건 꼼꼼하게 잘 세워서 풀기
// 0,0 지점에서 0,2 지점으로 갈때 직선으로 두번에 갈 수도 있지만 대각선으로 두번만에 갈 수도 있다는 것에 유의

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 버퍼리더
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		long w = Integer.parseInt(st.nextToken());
		long s = Integer.parseInt(st.nextToken());
		long answer;
		if (2*w <= s) { //대각선 길이보다 직선 길이의 합이 짧은 경우, 대각선 경로르 이용할 필요 없음
			answer = (w*x) + (w*y); 
		}
		else {
			if (s <= w) { // 대각선 길이가 직선 하나보다 짧거나 같은 경우, 최대한 대각선으로 이동하다가 직선구간처리, 
						  // 결국 홀수번 이동해야 될 때 w 한번 더하기
				if (Math.abs(x-y)%2 == 0) {
					answer = Long.max(x, y)*s;
				}
				else {
					answer = (Long.max(x, y)-1)*s + w;
				}
			}
			else { // 나머지 경우는 대각선으로 최대한 올라가서 남은 직선만큼 직선으로 이동
				answer = Long.min(x, y)*s + (Long.max(x,y) - Long.min(x, y))*w;
			}
			
		}
		System.out.println(answer);
	}
}