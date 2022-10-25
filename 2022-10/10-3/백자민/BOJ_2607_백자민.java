package week10_3;

/*
 * 1. 기준이 되는 문자열의 구성을 ch 배열에 저장한다.
 * 2. 1에서 만든 배열을 복사한 후, 새로 입력받은 문자열의 구성과 비교하며 같은 문자열이 몇 개 있는지 카운팅한다.(길이 차이가 2이상 나면 검사하지 않)
 * 3. 두 문자열의 길이가 같은 경우, 길이가 1 차이나는 경우를 따로 검사해준다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2607_백자민 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String word = br.readLine(); //기준
		int[] ch = new int[26];
		
		for(int i=0,size=word.length();i<size;i++) //검사할 필요 없는 경우
			ch[word.charAt(i)-'A']++;
		
		int result = 0;
		for(int i=0;i<N-1;i++) {
			String str = br.readLine();
			
			if(str.length()>word.length()+1 || str.length()<word.length()-1)
				continue;

			int[] temp = ch.clone();
			int cnt = 0;
			//구성 비교
			for(int j=0,size=str.length();j<size;j++) {
				if(temp[str.charAt(j)-'A']>0) {
					cnt++;
					temp[str.charAt(j)-'A']--;
				}
			}
			
			//두 문자열의 길이가 같은 경우
			if(word.length()==str.length()) {
				if(cnt==word.length() || cnt==word.length()-1)
					result++;
			}
			else if(word.length()+1==str.length()) { //기존 문자열 길이가 하나 더 큼
				if(cnt==word.length()) 
					result++;
			}
			else { //기존 문자열 길이가 하나 더 작음
				if(cnt==str.length())
					result++;
			}
		}
		
		System.out.println(result);
	}
}
