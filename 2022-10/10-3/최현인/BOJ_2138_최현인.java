// 2138 전구와 스위치
// 진짜 복잡한 문제였는데 알고보면 간단한 문제
// 한 번 반복으로 경우를 찾을 수 있다.
// 배열을 돌면서 i번째 전구를 끄고 켤때 i-1 번째 전구만 신경 써주면서 dp 처럼 만들어가면 된다
// 규칙이 자기 앞 전구의 상태를 맞춰나가는 거니까, 가장 첫번째 전구는 규칙을 적용하기 어려움, 그래서 첫번째 전구를 누르는 경우와 안누르는 경우를 전부 고려함
// 결과적으로 시간복잡도는 O(2n) 이 될것

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, answer;
	static boolean hasAnswer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 버퍼리더
		N = Integer.parseInt(br.readLine()); 
		//입력 받기
		char[] t1 = br.readLine().toCharArray();
		int[] arr1 = new int[N]; //1번째 전구를 누르는 결과를 저장할 배열
		int[] arr2 = new int[N]; //1번째 전구를 안누르는 결과를 저장할 배열
		for (int i = 0; i < N; i++) {
			arr1[i] = t1[i] -'0';
			arr2[i] = t1[i] -'0';
		}
		char[] t2 = br.readLine().toCharArray();
		int[] arr3 = new int[N];
		for (int i = 0; i < N; i++) {
			arr3[i] = t2[i] -'0';
		}
		if (check(arr1, arr3)) { // 전구를 눌러보기 전에 이미 같은지 먼저 검사
			System.out.println(0);
		}
		else {
			answer = Integer.MAX_VALUE;
			hasAnswer = false;
			findAnswer(1, arr1, arr3); //1번째 전구를 누르는 경우
			findAnswer(0, arr2, arr3); //1번째 전구를 누르지 않는 경우
			System.out.println(hasAnswer ? answer : -1);
		}
	}
	public static boolean check(int[] arr1, int[] arr2) {
		for (int i = 0; i < N; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	public static void opposit(int[] arr, int idx) {
		if (arr[idx] == 0) {
			arr[idx] = 1;
		}
		else {
			arr[idx] = 0;
		}
	}
	public static void findAnswer(int count, int[] nowArr, int[] targetArr) {
		if (count == 1) {
			opposit(nowArr, 0);
			opposit(nowArr, 1);
		}
		for (int i = 1; i < N; i++) {
			if (nowArr[i-1] != targetArr[i-1]) {
				count++;
				opposit(nowArr, i-1);
				opposit(nowArr, i);
				if (i < N-1) {
					opposit(nowArr, i+1);
				}
			}
		}
		if (check(nowArr, targetArr)) {
			hasAnswer = true;
			answer = Integer.min(count, answer);
		}
	}
}
