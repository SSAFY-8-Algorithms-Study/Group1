package week8_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1213_백자민 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String ans = "";

		int[] abc = new int[26];
		int one = 0;
		int oneidx = -1;

		for(int i=0;i<s.length();i++)
			abc[s.charAt(i)-'A']++;
		
		for(int i=0;i<abc.length;i++) {
			if(abc[i]%2!=0) {
				one++;
				oneidx = i;
			}
		}
		
		if(one>1) 
			System.out.println("I'm Sorry Hansoo");
		else {
			for(int i=0;i<26;i++) {
				for(int j=0;j<abc[i]/2;j++) {
					ans+=(char)(i+'A');
				}
			}
			if(one==1)
				ans += (char)(oneidx+'A');
			for(int i=25;i>=0;i--) {
				for(int j=0;j<abc[i]/2;j++) {
					ans+=(char)(i+'A');
				}
			}
			System.out.println(ans);
		}
		
	}
}
