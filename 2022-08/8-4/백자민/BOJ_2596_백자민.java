package week8_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2596_백자민 {
	
	//다른 문자 개수가 몇개인지 세기 
	static int check(String s1, String s2) {
		int cnt = 0;
		for(int i=0;i<6;i++) {
			if(s1.charAt(i) != s2.charAt(i))
				cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] abc = {"000000","001111","010011","011100","100110","101001","110101","111010"};
		String[] mean = {"A","B","C","D","E","F","G","H"};
		
		int N = Integer.parseInt(br.readLine());
		String message = br.readLine();
		
		int cnt=1;
		for(int i=0;i<N*6;i+=6) {
			String str = message.substring(i,i+6);

			int onecnt=0; //한 개 틀린거 셀 변수
			int idx = -1; //그거 인덱스 
			int twocnt=0; //두 개 이상 틀린거 셀 변수 
			
			for(int j=0;j<8;j++) {
				int iscorrect = check(abc[j], str);
				
				if(iscorrect == 0) {//맞는 문자를 찾았을 경우
					sb.append(mean[j]);
					onecnt=0;
					twocnt=0;
					break;
				}
				else if (iscorrect == 1) { //문자 하나 틀림
					onecnt++;
					idx = j;
				}
				else {
					twocnt++;
				}
			}
			
			if(onecnt == 1)
				sb.append(mean[idx]);
			
			if(twocnt==8) {
				System.out.println(cnt);
				System.exit(0);
			}
			cnt++;
		}
		System.out.println(sb);
	}
}
