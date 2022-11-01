package study.oct5;
import java.util.Arrays;
import java.util.Scanner;

// 수열 i~j번째 수까지 의 합이 M이 되는 경우의 수를 구하는 문제
// 첫번째 수부터 해서, start point와 end point를 정하고, end point를 
// 늘려가면서 M이 되는 수를 찾는다. 합이 M보다 작으면 end point를 늘리고, 합이 M보다 커지면
// start point를 늘린다. end point가 배열 끝에 도달해도 start point를 한칸 앞으로 늘리고 처음부터시작



public class BOJ2003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] map = new int[N];
		int ans = 0;
		for(int i=0;i<N;i++) {
			map[i] = sc.nextInt();
		}
		int s=0,e = 0;
		int sum = 0;
		while(s<N) {
			if(e>=N) {
				s++; e=s;
				sum = 0;
				continue;
			}
			sum += map[e];
//			System.out.println(sum+" "+s+" "+e);
			if(sum==M) {
				ans++;
				s++; e=s;
				sum = 0;
			}else if(sum<M) {
				e++;
			}else {
				s++; e=s;
				sum = 0;
			}
		}
		System.out.println(ans);
			
	}
}