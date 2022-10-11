import java.util.Arrays;
import java.util.Scanner;

//뭐 시도해보다가 안돼서 그지같이짬.
//i에서 j로가는 경로가 있으면 파악하는 문제로, i에서 j로 바로 가는 것이아닌 경유지를 거쳐서 갈수 있으므로
// 플로이드 워샬 방법 응용함. 경유지를 이용해서 갈 수 있으면 표시.
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		long[][] ans = new long[n][n];//?? 왜 long 타입
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//넌뭐임? map넣을때 같이 넣지 넣을꺼면 존재 이유도 모름
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans[i][j] = map[i][j];
			}
		}
		//
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (ans[i][k] == 1 && ans[k][j] == 1) {
						ans[i][j] = 1;
					}
				}
			}
		}
		print(n, ans);

	}

	static void print(int n, long[][] ans) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
//		System.out.println();
	}
}