import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

//부분수열의 합으로 만들 수 있는 수의 최고는 모든것을 다 더했을 때니, 입력을받으면서
//합을 구하고, 그 합의 크기+1 만큼 체크할 배열을 만든다.
//조합을 이용해서 부분수열로 만들수 있는 합들을 구해서 체크하고 1부터 for문으로 출력하면서 없는 수를 출력
public class Main {
	static int N;
	static int nums[];
	static boolean[] select;
	static int[] ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		nums = new int[N];
		select = new boolean[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
			sum += nums[i];
		}
		ans = new int[sum+2];
		subset(0);
		for(int i=1;i<=sum+1;i++) {
			if(ans[i]!=1) {
				System.out.println(i);
				System.exit(0);
			}
		}

	}

	private static void subset(int i) {
		if (i == N) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if (select[j]) {
					sum += nums[j];
				}
			}
			ans[sum] = 1;
			return;
		}
		select[i] = false;
		subset(i + 1);
		select[i] = true;
		subset(i + 1);
	}
}