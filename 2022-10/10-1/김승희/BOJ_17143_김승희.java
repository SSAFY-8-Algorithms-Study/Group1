import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 상어의 위치를 표현하는 전역변수 Shark[][] Sea
 * move()로 상어를 움직인다. 새로 Shark[][] 배열을 만들어서 사용. 이때, 이미 그 자리에 누가 있다면 size가 큰 것을 남긴다.
 * */

public class Main {
	static int R, C;
	static Shark[][] Sea;
	static int[] di = { 0, -1, 1, 0, 0 };
	static int[] dj = { 0, 0, 0, 1, -1 };

	static class Shark implements Comparable<Shark> {
		int i, j, speed, dir, size;

		public Shark(int i, int j, int speed, int dir, int size) {
			super();
			this.i = i;
			this.j = j;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		@Override
		public String toString() {
			return "Shark [i=" + i + ", j=" + j + ", speed=" + speed + ", dir=" + dir + ", size=" + size + "]";
		}

		@Override
		public int compareTo(Shark o) {
			if (this.i > o.i) {
				return 1;
			} else if (this.i < o.i) {
				return -1;
			} else {
				if (this.size > o.size) {
					return -1;
				} else if (this.size < o.size) {
					return 1;
				} else {
					return 0;
				}
			}
		};

		public boolean equals(Shark o) {
			if (this.i == o.i && this.j == o.j)
				return true;
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		R = Integer.parseInt(inArr[0]);
		C = Integer.parseInt(inArr[1]);
		int M = Integer.parseInt(inArr[2]);
		Sea = new Shark[R + 1][C + 1];
		for (int p = 0; p < M; p++) {
			inArr = br.readLine().split(" ");
			int i = Integer.parseInt(inArr[0]);
			int j = Integer.parseInt(inArr[1]);
			int speed = Integer.parseInt(inArr[2]);
			int dir = Integer.parseInt(inArr[3]);
			int size = Integer.parseInt(inArr[4]);
			Sea[i][j] = new Shark(i, j, speed, dir, size);
		} // end input

		int sum = 0;

		for (int j = 1; j < C + 1; j++) {
			for (int i = 1; i < R + 1; i++) {
				if (Sea[i][j] != null) {
					sum += Sea[i][j].size;
					Sea[i][j] = null;
					break;
				}
			}
			move();
//			print(j);
		}

		System.out.println(sum);
	}

	static void print(int q) {
		System.out.println("-----------------" + q + "----------------");

		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				if (Sea[i][j] != null) {
					System.out.print("S ");
				} else {
					System.out.print("- ");
				}
			}
			System.out.println("");
		}

		System.out.println("-----------------" + q + "----------------");
	}

	// 상어 움직이기. 움직이기 전 상어를 담고 있는 Sea, 움직인 후 상어를 담고있는 update.

	static void move() {
		Shark[][] update = new Shark[R + 1][C + 1];
		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				if (Sea[i][j] == null)
					continue;
				Shark s = Sea[i][j];
				int ni = s.i;
				int nj = s.j;
				int speed = s.speed;
				int dir = s.dir;
				if (dir == 1 || dir == 2) {
					speed = speed % ((R - 1) * 2);
				}
				if (dir == 3 || dir == 4) {
					speed = speed % ((C - 1) * 2);
				}
				int size = s.size;
				for (int k = 0; k < speed; k++) {
					ni += di[dir];
					nj += dj[dir];
					if (ni < 1 || nj < 1 || ni > R || nj > C) {
						dir = dir % 2 == 0 ? dir - 1 : dir + 1;
						ni += di[dir] * 2;
						nj += dj[dir] * 2;
					}
				}

				if (update[ni][nj] == null) {
					update[ni][nj] = new Shark(ni, nj, speed, dir, size);
				} else {
					if (update[ni][nj].size < size) {
						update[ni][nj] = new Shark(ni, nj, speed, dir, size);
					}
				}
			}
		}
		Sea = update;
	}

}
