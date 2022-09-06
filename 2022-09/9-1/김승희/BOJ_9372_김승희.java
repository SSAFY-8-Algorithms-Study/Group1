
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			String[] inArr = br.readLine().split(" ");
			int n = Integer.parseInt(inArr[0]);
			int m = Integer.parseInt(inArr[1]);
			for (int k = 0; k < m; k++) {
				br.readLine();
			}
			System.out.println(n - 1);
		}

	}

}
