import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] columns = new int[n];
		for (int i = 0; i < n; i++) {
			columns[i] = sc.nextInt();
		}

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			if (stack.isEmpty()) {
				stack.add(columns[i]);
			} else {
				while(stack.peek() <= columns[i]) {
					stack.pop();
					if(stack.isEmpty()) {
						break;
					}
				}
				stack.add(columns[i]);
			}
		}
		
		System.out.println(stack.size());

	}

}