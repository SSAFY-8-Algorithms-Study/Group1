import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		boolean[] isNotPrime = new boolean[n + 1];
		int answer = 0;
		for (int i = 2; i < n + 1; i++) {
			if (!isNotPrime[i]) { // 소수임
				for (int j = i; j < n + 1; j += i) {
					if (!isNotPrime[j]) {
						isNotPrime[j] = true;
						k--;
					}
					if (k == 0) {
						answer = j;
						System.out.println(answer);
						System.exit(0);
					}
				}
			}
		}
	}

}