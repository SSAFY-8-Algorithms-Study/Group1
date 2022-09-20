import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
// HashMap을 사용해서 들어오는 이름을 key로 해서 count를 해주었다. 
// count가 2면 명단에 추가
public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int N = Integer.parseInt(inArr[0]);
		int M = Integer.parseInt(inArr[1]);

		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String a = br.readLine();
			int cnt = map.getOrDefault(a, 0);
			map.put(a, cnt+1);
		}
		
		for(int i = 0; i < M; i++) {
			String a = br.readLine();
			int cnt = map.getOrDefault(a, 0);
			map.put(a, cnt+1);
		}
		
		ArrayList<String> noLS = new ArrayList<>();
		for(Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 2) {
				noLS.add(entry.getKey());
			}
		}
		
		Collections.sort(noLS);
		System.out.println(noLS.size());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < noLS.size(); i++) {
			sb.append(noLS.get(i) + "\n");
		}
		System.out.println(sb.toString());
	}

}
