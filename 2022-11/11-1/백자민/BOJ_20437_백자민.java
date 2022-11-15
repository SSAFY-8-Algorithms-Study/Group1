package week11_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문자열을 입력받아 문자열을 구성하는 각 문자의 개수를 센 후 조건에 따라 검사한다.
 * 하나의 문자에 대해 그 문자 다음~문자열 길이만큼 검사하면서 같은 문자의 개수를 세고, 개수가 k개가 되면 최솟값과 최댓값을 갱신한다.
 * 이 때 문자의 개수가 k개보다 작으면 조건에 만족하는 문자열을 만들 수 없으므로 제외한다. 
 * */

public class BOJ_20437_백자민 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
				
		for(int t=0;t<T;t++) {
			String w = br.readLine();
			int k = Integer.parseInt(br.readLine());
			
			
			//k가 1이면 최솟값, 최댓값이 자동으로 1이 됨
			if(k==1) {
				sb.append(1+" "+1+"\n");
				continue;
			}
			
			int[] ch = new int[26];
			//각 문자 개수 세기 
			for(int i=0;i<w.length();i++) {
				ch[w.charAt(i)-'a']++;
			}
			
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			for(int i=0;i<w.length();i++) {
				if(ch[w.charAt(i)-'a']<k) continue; //문자 개수가 k개보다 작으면 셀 필요 없음
				
				int cnt = 1;
				for(int j=i+1;j<w.length();j++) {
					if(w.charAt(i)==w.charAt(j)) cnt++; //같은 문자 개수 세기 
					if(cnt==k) {//k개 되면 최솟값, 최댓값 갱신
						min = Math.min(min, j-i+1);
						max = Math.max(max, j-i+1);
						break;
					}
				}
			}
			if(max==Integer.MIN_VALUE || min==Integer.MAX_VALUE) sb.append(-1+"\n");
			else sb.append(min+" "+max+"\n");
		}
		System.out.println(sb.toString());
	}
}
