import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[] btns = {300, 60, 10};
		int[] ans = {0, 0, 0};

		for(int i = 0; i < 3; i++) {
			ans[i] = input/btns[i];
			input -= ans[i] * btns[i];
			if(input == 0) {
				break;
			}
		}
		if(input != 0) {
			System.out.println(-1);
		}else {
			for(int i = 0; i < 3; i++) {
				System.out.print(ans[i] + " ");
			}
		}
	}

}
