import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j] = s.charAt(j)-'0';
			}
		}
		
		int ans = 1;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int k=1;i+k<N && j+k<M;k++) {
					int num = board[i][j];
					if(num==board[i+k][j] && num==board[i][j+k] && num==board[i+k][j+k]) {
						if (k+1 >ans)
							ans = k+1;
					}
				}
			}
		}
		
		
		System.out.println(ans*ans);
		
	}
}
