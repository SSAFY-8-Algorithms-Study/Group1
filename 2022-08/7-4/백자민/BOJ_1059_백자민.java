import java.util.Arrays;

import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		int[] nums = new int[L];
		
		for(int i=0;i<L;i++) {
			nums[i] = sc.nextInt();
		}
		
		int n = sc.nextInt();
		Arrays.sort(nums);
		int ans = 0;
		
		if(n<nums[0]) {
			ans = (nums[0]-n)*(n-1)+(nums[0]-n-1);
		} else {
			int A = 0, B = 0;
			for(int i=0;i<L;i++) {
				if(n == nums[i]) {
					ans = 0;
					break;
				}
				if(nums[i]<n && nums[i+1]>n) {
					A = nums[i];
					B = nums[i+1];
					ans = (n-A-1)*(B-n) + (B-n-1);
					break;
				}
			}
		}
		
		System.out.println(ans);
		
		
	}
}
