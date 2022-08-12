import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int idx = 1;
		for (int i = 2; i < 5000; i++) {
			for (int j = 1; j < i; j++) {
				if (idx == n) {
					if (i % 2 == 0) {
						System.out.println((i - j) + "/" + j);
					} else {
						System.out.println(j + "/" + (i - j));
					}
					System.exit(0);
				}
				idx++;
			}
		}

	}

}