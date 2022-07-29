import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int n = Integer.parseInt(inArr[0]);
		int m = Integer.parseInt(inArr[1]);
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = (int) (temp.charAt(j) - '0');
			}
		}
		int max = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int len = 1;
				int nx = i + len;
				int ny = j + len;
				while (true) {

					if (nx >= n || ny >= m) {
						break;
					}
					if (map[i][j] == map[nx][j] && map[nx][j] == map[i][ny] && map[i][ny] == map[nx][ny]) {
						max = Math.max(max, len + 1);
					}
					len++;
					nx = i + len;
					ny = j + len;

				}
			}
		}
		System.out.println(max * max);
	}

}