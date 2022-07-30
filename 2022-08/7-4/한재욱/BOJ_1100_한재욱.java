import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] map = new String[8];
		for(int i=0;i<8;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken();
		}
		int cnt = 0;
		for(int i=0;i<8;i++) {//홀수 검사
			String line = map[i]; 
			if(i%2==1) {
				for(int j=1;j<line.length();j+=2) {
					if(line.charAt(j)=='F') {
						cnt++;
					}
				}
			}
			else {//짝수 검사
				for(int j=0;j<line.length();j+=2) {
					if(line.charAt(j)=='F') {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}