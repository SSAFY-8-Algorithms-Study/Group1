import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);

		int chk = sc.nextInt();
		int cnt = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			if (num[i] == chk) {
				cnt = -1;
				break;
			}
			if (num[i] < chk) {
				start = num[i];
			} else {
				end = num[i];
				break;
			}
		}
		if (cnt == -1) {
			System.out.println(0);
			System.exit(0);
		}

		if (start == 0) {
			start = 1;
			end--;
		} else {
			start++;
			end--;
		}

		int answer = (chk - start + 1) * (end - chk + 1);
		answer--;
		System.out.println(answer);
	}

}