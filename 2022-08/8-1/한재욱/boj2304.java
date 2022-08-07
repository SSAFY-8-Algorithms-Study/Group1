package Aug1;

import java.util.Scanner;

public class boj2304 {
	static int x;
	static int xh;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] map = new int[1001];
		int max = 0;
		int maxidx = -1;
		int area = 0;
		int start = 1001;
		int end = 0;

		for (int i = 0; i < n; i++) {
			int l = sc.nextInt(), h = sc.nextInt();
			map[l] = h;
			start = Math.min(l, start);
			end = Math.max(l, end);
			if (max <= h) {
				max = h;
				maxidx = l;
			}
		}
		x = start;
		xh = map[start];
		for (int i = start+1; i <= maxidx; i++) {
			if (map[i] != 0 && (map[i] >= xh)) {
				area += xh * (i - x);
				x = i;
				xh = map[i];
			}
		}
		x = end;
		xh = map[end];
		for (int i = end-1; i >= maxidx; i--) {
			if (map[i] != 0 && (map[i] >= xh)) {
				area += xh * (x-i);
//				System.out.println("x "+x+" xh "+xh+" "+area);
				x = i;
				xh = map[i];
			}
		}
		area += max;
		System.out.println(area);
	}
}
