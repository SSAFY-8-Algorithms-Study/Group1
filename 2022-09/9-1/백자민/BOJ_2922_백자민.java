package week9_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2922_백자민 {
	
	static char[] word;
	
	static long happyword(int idx, int vcnt, int ccnt, boolean lflag) {
		if(vcnt>2 || ccnt>2) return 0;
			
		if(idx==word.length) {
			if(lflag) return 1;
			else return 0;
		}
		
		long ans=0;
		
		if(word[idx]=='_') {
			ans += happyword(idx+1, 0, ccnt+1,lflag)*20;
			ans += happyword(idx+1, vcnt+1, 0,lflag)*5;
			ans += happyword(idx+1, 0, ccnt+1, true)*1;
		}
		else {
			if(word[idx]=='v')
				ans += happyword(idx+1, vcnt+1, 0, lflag);
			else {
				if(word[idx]=='L')
					ans += happyword(idx+1, 0, ccnt+1, true);
				else
					ans += happyword(idx+1, 0, ccnt+1, lflag);
			}
		}
		
		return ans;
		
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		word = br.readLine().toCharArray();
		
		boolean Lflag = false;
		
		for(int i=0,size=word.length;i<size;i++) {
			if(word[i]=='A' || word[i]=='E' || word[i]=='I' || word[i]=='O' || word[i]=='U') {
				word[i] = 'v';
			}
			else if(word[i]=='L') {
				word[i] = 'L';
				Lflag = true;
			}
			else if(word[i]!='_')
				word[i] = 'c';
		}
		
		System.out.println(happyword(0,0,0,Lflag));
	}  
}

//while(idx<100) {
//	if(word[idx]!='_') {
//		//지금까지 만든거 검사 -> 조건 위배하면 이거는 건너뛰어도 됨(가지치기) 
//		int ccnt=0, vcnt=0, lcnt=0;
//		for(int i=0;i<idx;i++) {
//			if(word[i]=='v') {
//				vcnt++;
//				ccnt=0;
//			}
//			else {
//				if(word[i]=='L')
//					lcnt++;
//				ccnt++;
//				vcnt = 0;
//			}
//			
//			if(ccnt>2 || vcnt>2) //3개 이상 연속된 경우는 안되니까 0 
//				return 0;
//			
//			if(lcnt==1)
//				return 1; //L을 넣는 경우의 수는 한가지 
//			else
//				return 0;
//		}
//	}
//	
//	if(word[idx]=='_') {
//		long ans=0;
//		
//		//v 넣어보기 
//		word[idx] = 'v';
//		ans += 5*happyword(idx+1);
//		
//		//c 넣어보기 
//		word[idx] = 'c';
//		ans += 21*happyword(idx+1);
//		happyword(idx+1);
//		
//		//L 넣어보기 
//		if(!Lflag) {
//			word[idx]='L';
//			Lflag = true;
//			ans += 1*happyword(idx+1);
//		}
//		
//		return ans;
//	}
//	idx++;
//}
//return 0;
