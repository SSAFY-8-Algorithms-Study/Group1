import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	// 가로 체크할 맵과, 세로 체크할 맵을 만들어 둔뒤.
	// 가로 체크할때 판자가 가로라면 값을 추가해주고, 다른 판자가 안나오면 넘어가고 다른 판자가 넘어가면 초기화시켜줘서 
	// 판자가 또 나온다면 판자체크해서 나무 판자의 개수를 출력.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ans = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}//end
		char[][] map2 = new char[M][N];
		reverse(map2, map);
		count(map, '-');//가로 판자 체크
		count(map2, '|');//세로 판자 체크
		System.out.println(ans);
	}

	private static void reverse(char[][] map2, char[][] map) {
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				map2[i][j] = map[j][i];
			}
		}
	}

	private static void count(char[][] map22, char c) {
		for (int i = 0; i < map22.length; i++) {
			int cnt = 0;//같은 판자가 인접한다면 같은 나무판자 체크.
			for (int j = 0; j < map22[0].length; j++) {
				if (map22[i][j] == c) {
					if (++cnt == 1) {
						ans++;
					}
				}else {//다른판자가 나온다면 초기화
					cnt = 0;
				}
			}
		}

	}

}