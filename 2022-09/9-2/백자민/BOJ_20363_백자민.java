package week9_2;

import java.util.Scanner;

public class BOJ_20363_백자민 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		System.out.println((int)( Math.floor(x+y+(Math.min(x, y)/10))));
	}
}
