package Aug3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj17608 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 1, mh = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if(mh<arr[i]) {
				cnt++;
				mh = arr[i];
			}
		}
		System.out.println(cnt);

	}
}
