package bj2304;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max_height = 0;
		int max_cnt = 0;

		Tuple[] columns = new Tuple[n];
		for (int i = 0; i < n; i++) {
			int p = sc.nextInt();
			int h = sc.nextInt();
			columns[i] = new Tuple(p, h);
			if (h > max_height) {
				max_height = h;
				max_cnt = 1;
			} else if (h == max_height) {
				max_cnt++;
			}
		}
		Arrays.sort(columns);

		int l = columns[0].pos;
		int r = columns[n - 1].pos;
		int idx = 0;
		int prev = 0;
		int area = 0;
		int end = 0;

		for (int i = l; i <= r; i++) {
			if (i == columns[idx].pos) {
				if (columns[idx].height == max_height) {
					end = i;
					max_cnt--;
					idx++;
					break;
				}
				if (prev < columns[idx].height) {
					prev = columns[idx].height;
				}
				idx++;
			}
			area += prev;
		}
		if (max_cnt > 0) {
			while (true) {
				if (columns[idx].height == max_height) {
					max_cnt--;
				}
				if (max_cnt == 0) {
					area += (columns[idx].pos - end) * max_height;
					end = columns[idx].pos;
					break;
				}
				idx++;
			}
		}
		area += max_height;
		idx = n - 1;
		prev = 0;
		for (int i = r; i > end; i--) {
			if (i == columns[idx].pos) {
				if (prev < columns[idx].height) {
					prev = columns[idx].height;
				}
				idx--;
			}
			area += prev;
		}
		System.out.println(area);
	}

}

class Tuple implements Comparable<Tuple> {
	int pos, height;

	public Tuple(int p, int h) {
		pos = p;
		height = h;
	}

	@Override
	public int compareTo(Tuple o) {
		if (this.pos > o.pos) {
			return 1;
		} else if (this.pos == o.pos) {
			return 0;
		} else {
			return -1;
		}
	}
}
