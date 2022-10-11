import java.util.Scanner;

public class Main {
	static int r, c, m;
	static Shark[][] map;
	static Shark[][] moveS;
	static int ans;
	static int di[] = { 0, -1, 1, 0, 0 };
	static int dj[] = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		r = sc.nextInt(); 
		c = sc.nextInt(); 
		m = sc.nextInt();
		ans = 0;
		map = new Shark[r + 1][c + 1];
		moveS = new Shark[r + 1][c + 1];

		for (int i = 0; i < m; i++) {
			int ri = sc.nextInt();
			int cj = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			int z = sc.nextInt();
			map[ri][cj] = new Shark(s, d, z);
		} // end
		int hum = 0;
		while (true) {
			hum++;
			if(hum>c)break;
			fishing(hum);
			moveShark();
		}
		System.out.println(ans);

	}

	private static void moveShark() {
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (map[i][j] != null) {
					move(i, j);
				}
			}
		}
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				map[i][j] = moveS[i][j];
				moveS[i][j] = null;
			}
		}
	}

	private static void move(int i, int j) {
		Shark s = map[i][j];
		int dir = s.d;
		int ni = i + s.s * di[dir];
		int nj = j + s.s * dj[dir];
		while (true) {
			if (0 < ni && ni <= r && 0 < nj && nj <= c)
				break;
			dir = reverse(dir);
			if (ni < 1) {
				ni = 1 + (1 - ni);
			} else if (ni > r) {
				ni = r + (r - ni);
			} else if (nj > c) {
				nj = c + (c - nj);
			} else if (nj < 1) {
				nj = 1 + (1 - nj);
			}
		}
		map[i][j] = null;
		if (moveS[ni][nj] != null) {
			if (moveS[ni][nj].s < s.s)
				moveS[ni][nj] = new Shark(s.s, dir, s.z);
		}else {
			moveS[ni][nj] = new Shark(s.s, dir, s.z);
		}

	}

	static int reverse(int idx) {
		switch (idx) {
		case 1:
			return 2;
		case 2:
			return 1;
		case 3:
			return 4;
		case 4:
			return 3;
		}
		return 0;
	}

	private static void fishing(int j) {
		for (int i = 1; i <= r; i++) {
			if (map[i][j] != null) {
				ans += map[i][j].z;
				map[i][j] = null;
				return;
			}
		}
	}

	static class Shark {
		int s, d, z;

		public Shark(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}
	static void print() {
		for(int i=1;i<=r;i++) {
			for(int j=1;j<=c;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}