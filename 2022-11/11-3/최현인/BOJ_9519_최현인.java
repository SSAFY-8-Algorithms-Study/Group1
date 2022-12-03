package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
	static char[] words;
	static char[] tempWords;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		words = br.readLine().toCharArray();
		
		N = words.length;
		
		tempWords = new char[N];
		for (int i = 0; i < N; i++) {
			tempWords[i] = words[i];
		}
		
		swap();
		ArrayList<String> wordList = new ArrayList<>();
		while (true) {
			if (compareWords()) {
				break;
			}
			wordList.add(new String(tempWords));
			swap();
		}
		wordList.add(new String(tempWords));
		int nowLen = wordList.size();
		int nowIdx = nowLen-1;
		
		int findIdx = X%nowLen;
		
		
		
		System.out.println(wordList.get(nowIdx-findIdx));
	}
	public static void swap() {
		char[] newWords = new char[N];
		int l = 0;
		int r = N-1;
		
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				newWords[i] = tempWords[l++];
			}
			else {
				newWords[i] = tempWords[r--];
			}
		}
		tempWords = newWords;
	}
	public static boolean compareWords() {
		for (int i = 0; i < N; i++) {
			if (words[i] != tempWords[i]) {
				return false;
			}
		}
		return true;
	}
}