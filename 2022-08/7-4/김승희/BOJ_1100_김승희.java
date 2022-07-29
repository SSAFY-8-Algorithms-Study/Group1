import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 8;
		char[][] map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String inArr = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = inArr.charAt(j);
			}
		}
		int cnt = 0;
		boolean white = true;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 1) {
				white = false;
			} else {
				white = true;
			}
			for (int j = 0; j < n; j++) {
				if (white && map[i][j] == 'F') {
					cnt++;
				}
				white = !white;
			}
		}
		System.out.println(cnt);
	}

}