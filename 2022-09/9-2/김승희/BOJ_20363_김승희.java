import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int goal_x = sc.nextInt();
		int goal_y = sc.nextInt();

		 int ans = 0;
		
		if(goal_x > goal_y) {
			ans = goal_x;
			ans += goal_y;
			ans += goal_y/10;
		}else {
			ans = goal_y;
			ans += goal_x;
			ans += goal_x/10;
		}
		System.out.println(ans);

	}

}
