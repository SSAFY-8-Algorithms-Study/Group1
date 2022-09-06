package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int b[] = {300, 60,10};
		int count[] = new int[3];
		
		for (int i = 0; i < 3; i++) {
			if (N >= b[i]) {
				count[i] += N/b[i];
				N %= b[i];
			}
		}
		if (N != 0) {
			System.out.println(-1);
		}
		else {
			for (int i = 0; i < 3; i++) {
				System.out.print(count[i] + " ");
			}
		}
	}
}