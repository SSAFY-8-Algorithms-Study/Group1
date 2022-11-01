package week10_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 슬라이딩 윈도우 방식을 사용했다. 현재 구간의 오른쪽 인덱스가 증가하면 총합을 계속해서 더하고, 왼쪽 인덱스가 증가하면 총합에서 현재 인덱스의 수만큼 뺀다.
 * 즉, 현재 구간의 총합이 기준보다 작으면 구간을 오른쪽으로 확장시킨다. 반대의 경우에는 왼쪽 인덱스를 증가시켜 구간의 범위를 줄인다. 
 * */

public class BOJ_2003_백자민 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int temp=0,cnt=0;
		
		for(int i=0,j=0;j<N;j++) {
			temp += nums[j]; 
			if(temp<M) continue; //현재 수의 합이 기준보다 작으면 계속 더하기(end 인덱스 이동) 
			
			if(temp>M) { //현재 수의 합이 기준보다 크면 작거나 같아질 때까지 빼기(start 인덱스 이동)
				while(temp>M) {
					temp -= nums[i];
					i++;
				}
			}
			
			if(temp==M) { //만약 같으면 카운트 증가하고 제일 왼쪽 빼기(다음 진행을 위해)
				cnt++;
				temp -= nums[i];
				i++;
			}
		}
		
		System.out.println(cnt);
	}
}
