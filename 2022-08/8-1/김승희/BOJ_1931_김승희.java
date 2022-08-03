package bj1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Tuple[] times = new Tuple[n];
		for (int i = 0; i < n; i++) {
			String[] inArr = br.readLine().split(" ");
			int s = Integer.parseInt(inArr[0]);
			int e = Integer.parseInt(inArr[1]);

			times[i] = new Tuple(s, e);
		}
		Arrays.sort(times);
		int cnt = 1;
		int end = times[0].end;
		for (int k = 1; k < n; k++) {
			if (times[k].start >= end) {
				end = times[k].end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}

class Tuple implements Comparable<Tuple> {
	int start, end;

	public Tuple(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public int compareTo(Tuple o) {
		if (this.end > o.end) {
			return 1;
		} else if (this.end == o.end) {
			if (this.start > o.start) {
				return 1;
			} else if (this.start == o.start) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}