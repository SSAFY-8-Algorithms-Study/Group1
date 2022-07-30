import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1051_ {
	public static boolean squarecheck(int[][]map, int n) {
		for(int i=0; i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(i+n<map.length&&j+n<map[i].length) {
					if(map[i][j]==map[i][j+n]&&map[i][j]==map[i+n][j]&&map[i][j]==map[i+n][j+n]) {
//						System.out.println("n :"+n+" "+map[i][j]+" "+map[i][j+n]+" "+map[i+n][j]+" "+map[i+n][j+n]);		
						return true;
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
		int [][] map = new int[n][m];
		int area = 1;
		for(int i=0;i<n;i++) {
			String tmp = br.readLine();
			for(int j=0;j<tmp.length();j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		int max = (n>=m)? m:n;
		for(int i=1;i<max;i++) {
			if(squarecheck(map, i)) {
				area = (i+1)*(i+1);
			}
		}
		System.out.println(area);
		
		
	}
}