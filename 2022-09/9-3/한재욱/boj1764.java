package Sep3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj1764 {
	//baekjoon 1764. siver 4
	//김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
	/* (Linkedlist를 사용하면 시간초과 가 남)
	 * Hashset을 만들고, 듣도못한사람 추가하고
	 * 보도 못한사람이 듣도못한사람에 포함되어 있으면 답으로 간주하고 리스트에 추가함.
	 * 정렬해서 정답 출력.
	 * */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<>(); 
		LinkedList<String> ans = new LinkedList<>();
		for(int i=0;i<n;i++) {
			hs.add(br.readLine());//듣도못한사람.
		}
		
		for(int i=0;i<m;i++) {
			String txt = br.readLine();
			if(hs.contains(txt)) {
				ans.add(txt);
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}
}
