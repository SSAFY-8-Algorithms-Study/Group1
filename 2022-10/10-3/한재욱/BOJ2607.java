import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// HASHMAP으로 처음단어를 담고(그 단어 있으면 +1씩), 비교할단어 담는 MAP을 만들어서
// A~Z(65~90)까지 몇개의 단어썼는지 확인하면서, 초기단어와 비교할 단어에서 MAP에 있는 단어의 개수를 빼줌.
// 각 단어의 길이와 몇개 차이 있는지 확인후, 길이가 다르면 다 같아야. 길이가 같으면 한개까지 달라도되는 규칙에 따라 정답이 되는지 확인후 출력.
public class BOJ2607 {
	static int N, ans;
	static Map<Character, Integer> init;
	static Map<Character, Integer> compareMap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String start = br.readLine();
		init = new HashMap<>();
		ans = 0;
		for (int i = 0; i < start.length(); i++) {
			char t = start.charAt(i);
			if (init.containsKey(t)) {
				init.put(t, init.get(t) + 1);
			} else {
				init.put(t, 1);
			}
		}
//		for (char k : init.keySet()) {
//			System.out.println(k + " " + init.get(k));
//		}
		for (int i = 1; i < N; i++) {
			compareMap = new HashMap<>();
			String txt = br.readLine();
			for (int j = 0; j < txt.length(); j++) {
				char t = txt.charAt(j);
				if (compareMap.containsKey(t)) {
					compareMap.put(t, compareMap.get(t) + 1);
				} else {
					compareMap.put(t, 1);
				}
			}
			compareWord();
		}

		System.out.println(ans);
	}

	private static void compareWord() {//길이가 다르면 다 같아야. 길이가 같으면 한개까지 달라도.
		int initsize = 0;
		int compsize = 0;
		int diffcnt = 0;
		for(int i=65;i<=90;i++) { //A~Z
			char k = (char) i;
			int a = compareMap.get(k)==null?0:compareMap.get(k);
			int b = (init.get(k)==null?0:init.get(k));
			if(compareMap.get(k)!=init.get(k)) {
				diffcnt += Math.abs(a-b);
			}
			compsize += a;
			initsize += b;;
		}
		if((Math.abs(initsize-compsize)==1&&diffcnt<2)||(initsize==compsize&&diffcnt<=2)) ans++;;
	}

}