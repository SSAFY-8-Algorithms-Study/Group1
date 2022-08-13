package Aug2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class boj3425 {
	static LinkedList<String> list;
	static int[] stack;
	static int top;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb  = new StringBuilder();
		stack = new int[1001];
		while (true) {
			list = new LinkedList<>();
			String txt = br.readLine();
			if (txt.equals("QUIT"))
				break;
			while (true) {
				if (txt.equals("END"))
					break;
				String[] stxt = txt.split(" ");
				if (stxt.length == 1) {
					list.add(stxt[0]);
				} else {
					list.add(stxt[0]);
					list.add(stxt[1]);
				}
				txt = br.readLine();
			}
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				top = 0;
				int num = Integer.parseInt(br.readLine());
				func(num);
			}
			sb.append("\n");
			br.readLine();			
		}
		System.out.println(sb);
	}

	public static void func(int num) {
		stack[++top] = num; // top=1부터 시작.
		for (int i = 0; i < list.size(); i++) {
			String command = list.get(i);
			switch (command) {
			case "NUM":
				stack[top+1] = Integer.parseInt(list.get(i + 1));
				top++;
				break;
			case "POP":
				if(top==0) {
					sb.append("ERROR").append("\n");
					return;
				}
				stack[top--] = 0;
				break;
			case "INV":
				if(top==0) {
					sb.append("ERROR").append("\n");
					return;
				}
				if(Integer.MIN_VALUE>-1 *(long)stack[top]) {
					sb.append("ERROR").append("\n");
					return;
				}
				stack[top] = -1 * stack[top];
				break;
			case "DUP":
				if(top==0) {
					sb.append("ERROR").append("\n");
					return;
				}
				stack[top+1] = stack[top];
				top++;
				break;
			case "SWP":
				if(top<2) {
					sb.append("ERROR").append("\n");
					return;
				}
				int tmp = stack[top];
				stack[top] = stack[top-1];
				stack[top-1] = tmp;
				break;
			case "ADD":
				if(top<2) {
					sb.append("ERROR").append("\n");
					return;
				}
				if(Integer.MAX_VALUE<(long)stack[top]+(long) stack[top-1]) {
					sb.append("ERROR").append("\n");
					return;
				}
				stack[top-1] = stack[top] + stack[top-1];
				stack[top] =0;
				top--;
				break;
			case "SUB":
				if(top<2) {
					sb.append("ERROR").append("\n");
					return;
				}
				if(Integer.MIN_VALUE>(long) stack[top-1]-(long)stack[top]) {
					sb.append("ERROR").append("\n");
					return;
				}
				stack[top-1] = stack[top-1] + stack[top];
				stack[top--] =0;
				break;
			case "MUL":
				if(top<2) {
					sb.append("ERROR").append("\n");
					return;
				}
				if(Integer.MAX_VALUE<(long)stack[top]*(long) stack[top-1]) {
					sb.append("ERROR").append("\n");
					return;
				}
				stack[top-1] = stack[top-1] * stack[top];
				stack[top--] =0;
				break;
			case "DIV":
				if(top<2) {
					sb.append("ERROR").append("\n");
					return;
				}
				if(stack[top]==0) {
					sb.append("ERROR").append("\n");
					return;
				}
				stack[top-1] = stack[top-1] / stack[top];
				stack[top--] =0;
				break;
			case "MOD":
				if(top<2) {
					sb.append("ERROR").append("\n");
					return;
				}
				if(stack[top]==0) {
					sb.append("ERROR").append("\n");
					return;
				}
				stack[top-1] = stack[top-1] % stack[top];
				stack[top--] =0;
				break;

			default:
				break;
			}
		}
		if(top!=1) {
			sb.append("ERROR").append("\n");
			return;
		}
		sb.append(stack[top]).append("\n");
		for(int i=0;i<=top;i++) {
			stack[i] = 0;
		}
	}

}
