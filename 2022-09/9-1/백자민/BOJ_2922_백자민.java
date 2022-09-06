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


