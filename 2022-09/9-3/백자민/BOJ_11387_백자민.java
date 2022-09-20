import java.util.Scanner;

public class Main {
	
	static double calculate(int[] cp, int[] wp) {
		return (cp[0]+wp[0]) * (1.0+(cp[1]+wp[1])/100.0) 
				* ((1.0-Math.min((cp[2]+wp[2])/100.0,1.0)) 
						+ Math.min((cp[2]+wp[2])/100.0,1.0) * ((cp[3]+wp[3])/100.0) ) 
				* (1.0+(cp[4]+wp[4])/100.0);
	}
	
	static String isGood(int[] cp , int[] wp1, int[] wp2) { //cp는 cree or pabu, wp1은 자기무기, wp2는 남의무기
		
		for(int i=0;i<5;i++) { //일단 내꺼 버림
			cp[i] -= wp1[i];
		}
		
		
		int result = (int) (calculate(cp,wp2) -calculate(cp,wp1)); //남의 무기가 더 좋으면 양수 아님 음수
		
		if(result>0)
			return "+";
		else if(result<0)
			return "-";
		return "0";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] input = new int[4][5]; //0:cree, 1:pabu, 2:creeWp, 3:pabuWp
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<5;j++) {
				input[i][j] = sc.nextInt();
			}
		}
		System.out.println(isGood(input[0], input[2], input[3]));
		System.out.println(isGood(input[1],input[3], input[2]));
	}
}
