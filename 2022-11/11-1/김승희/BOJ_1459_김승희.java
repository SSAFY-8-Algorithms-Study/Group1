package boj1459;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 좌표 (x, y) t1 t2
 * 모든 칸을(x + y) 가로 세로로 가는 경우 -> (x+y) * t1
 * min(x, y)
 * */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inarr = br.readLine().split(" ");
		long x = Long.parseLong(inarr[0]);
		long y = Long.parseLong(inarr[1]);
		long t1 = Long.parseLong(inarr[2]);
		long t2 = Long.parseLong(inarr[3]);
		
		// 가로 세로로만 가는 경우
		long sum1 = (x + y) * t1;
		// (가로 세로), 대각선으로 가는 경우
		long max = Math.max(x, y);
		long min = Math.min(x, y);
		
		long sum2 = min * t2;
		sum2 += (max-min) * t1;
		
		// 대각선으로 가는 경우
		long sum3 = min * t2;
		if((max-min) % 2 == 1) {// 가로 세로로는 1번, 나머지는 모두 대각선으로 가는 경우
			sum3 += (max-min-1) * t2 + t1;
		}else {// 대각선으로만 가는 경우
			sum3 += (max-min) * t2;
		}
		
		System.out.println(Math.min(sum1, Math.min(sum2, sum3)));
	}

}
