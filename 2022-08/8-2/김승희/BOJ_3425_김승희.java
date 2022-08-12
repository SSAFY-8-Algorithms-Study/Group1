import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	static Stack<Long> stack;

	public static void main(String[] args) throws IOException {
		stack = new Stack<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		ArrayList<String> op = new ArrayList<>();
		while (!input.equals("QUIT")) {
			if (input.equals("END")) {
				int n = Integer.parseInt(br.readLine());
				long[] number = new long[n];
				for (int i = 0; i < n; i++) {
					number[i] = Long.parseLong(br.readLine());
				}
				System.out.println(process(n, number, op).toString());
				op.clear();
				br.readLine();
			} else {
				op.add(input);
			}
			input = br.readLine();
		}

	}

	static StringBuffer process(int n, long[] number, ArrayList<String> op) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			stack = new Stack<>();
			stack.add(number[i]);
			boolean chk = false;
			for (int j = 0; j < op.size(); j++) {
				boolean b = OP(op.get(j).split(" "));
				if (!b) {
					chk = true;
					break;
				}
			}
			if (chk || stack.size() != 1) {
				sb.append("ERROR\n");
			} else {
				sb.append(stack.pop() + "\n");
			}
		}
		return sb;
	}

	static boolean OP(String[] op) {
		switch (op[0]) {
		case "NUM": {
			stack.add(Long.parseLong(op[1]));
			break;
		}
		case "POP": {
			if (!stack.isEmpty()) {
				stack.pop();
			} else {
				return false;
			}
			break;
		}
		case "INV": {
			if (!stack.isEmpty()) {
				long x = stack.pop();
				stack.add(-x);
			} else {
				return false;
			}
			break;
		}
		case "DUP": {
			if (!stack.isEmpty()) {
				stack.add(stack.peek());
			} else {
				return false;
			}
			break;
		}
		case "SWP": {
			if (stack.size() >= 2) {
				long a = stack.pop();
				long b = stack.pop();
				stack.add(a);
				stack.add(b);
			} else {
				return false;
			}
			break;
		}
		case "ADD": {
			if (stack.size() >= 2) {
				long a = stack.pop();
				long b = stack.pop();
				if (Math.abs(a + b) > 1000000000L) {
					return false;
				} else {
					stack.add(a + b);
				}
			} else {
				return false;
			}
			break;
		}
		case "SUB": {
			if (stack.size() >= 2) {
				long a = stack.pop();
				long b = stack.pop();
				if (Math.abs(b - a) > 1000000000L) {
					return false;
				} else {
					stack.add(b - a);
				}
			} else {
				return false;
			}
			break;
		}
		case "MUL": {
			if (stack.size() >= 2) {
				long a = stack.pop();
				long b = stack.pop();
				if (Math.abs(a * b) > 1000000000L) {
					return false;
				} else {
					stack.add(a * b);
				}

			} else {
				return false;
			}
			break;
		}
		case "DIV": {
			if (stack.size() >= 2) {
				int cnt = 0;
				long a = stack.pop();
				long b = stack.pop();
				if (a == 0) {
					return false;
				}
				long ans = Math.abs(b) / Math.abs(a);
				if (ans > 1000000000L) {
					return false;
				} else {
					if (a < 0)
						cnt++;
					if (b < 0)
						cnt++;
					if (cnt == 1) {
						stack.add(-ans);
					} else {
						stack.add(ans);
					}
				}
			} else {
				return false;
			}
			break;
		}
		case "MOD": {
			if (stack.size() >= 2) {
				long a = stack.pop();
				long b = stack.pop();
				if (a == 0) {
					return false;
				}
				long ans = Math.abs(b) % Math.abs(a);
				if (ans > 1000000000L) {
					return false;
				} else {
					if (b < 0) {
						ans *= -1;
					}
					stack.add(ans);
				}
			} else {
				return false;
			}
			break;
		}
		}
		return true;
	}

}