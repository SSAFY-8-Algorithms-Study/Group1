import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new TreeMap<>();
		int cnt = 0;
		for(int i=0;i<N+M;i++) {
			if(i<N) {
				map.put(br.readLine(), 1);
				continue;
			}
			String s = br.readLine();
			if(map.get(s)!=null && map.get(s)==1) {
				map.put(s, 2);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		for(String key: map.keySet()) {
			if(map.get(key)==2)
				System.out.println(key);
		}
	}
}
