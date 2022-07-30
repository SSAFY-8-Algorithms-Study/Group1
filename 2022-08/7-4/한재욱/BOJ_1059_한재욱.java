import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int[] set1 = new int[l];
		int cnt = 0;
		boolean small = false;
		for (int i = 0; i < l; i++) {
			set1[i] = sc.nextInt();
		}
		Arrays.sort(set1);
		
		int n = sc.nextInt();
		int a = 0, b = 0;
		if(n<set1[0])
			cnt = (set1[0]-n)*(n)-1;
			else {
				
				for (int i = 0; i < set1.length - 1; i++) {
					if (set1[i] < n && set1[i + 1] >n) {
						a = set1[i];
						b = set1[i + 1];
						cnt = (n - a) * (b - n) - 1;
					}
					else if(set1[i]==n||set1[i+1]==n) {
						cnt = 0;
					}
				}
			}

		System.out.println(cnt);
	}
}