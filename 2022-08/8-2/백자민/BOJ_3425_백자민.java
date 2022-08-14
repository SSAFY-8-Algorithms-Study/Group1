package week8_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3425_백자민 {
	
	static ArrayList<String[]> list;
	static Stack<long[]> stack;
	static long limit = 1000000000;
	
	static boolean run(long n) {
		stack.push(new long[] {n});
		for (String[] currList : list) {
			if ("NUM".equals(currList[0])) {
				stack.push(new long[] {Long.parseLong(currList[1])});
			}
			else if ("POP".equals(currList[0])) {
                if (stack.isEmpty())
                    return false;
                stack.pop();
			}
			else if ("INV".equals(currList[0])) {
                if (stack.isEmpty())
                    return false;
                long n1 = stack.peek()[0];
                stack.pop();
                stack.push(new long[] {-n1});
			}    
			else if ("DUP".equals(currList[0])) {
                if (stack.isEmpty())
                    return false;
                stack.push(stack.peek());
			}
			else if ("SWP".equals(currList[0])) {
                if (stack.size() < 2)
                    return false;
                long n1 = stack.peek()[0];
                stack.pop();
                long n2 = stack.peek()[0];
                stack.pop();
                stack.push(new long[] {n1});
                stack.push(new long[] {n2});
			}
			else if ("ADD".equals(currList[0])) {
                if (stack.size() < 2)
                    return false;
                long n1 = stack.peek()[0];
                stack.pop();
                long n2 = stack.peek()[0];
                stack.pop();
                stack.push(new long[] {n1+n2});
			}
			else if ("SUB".equals(currList[0])) {
                if (stack.size() < 2)
                    return false;
                long n1 = stack.peek()[0];
                stack.pop();
                long n2 = stack.peek()[0];
                stack.pop();
                stack.push(new long[] {n2-n1});
			}
			else if ("MUL".equals(currList[0])) {
                if (stack.size() < 2)
                    return false;
                long n1 = stack.peek()[0];
                stack.pop();
                long n2 = stack.peek()[0];
                stack.pop();
                stack.push(new long[] {n1*n2});
			}
			else if ("DIV".equals(currList[0])) {
                if (stack.size() < 2)
                    return false;
                long n1 = stack.peek()[0];
                stack.pop();
                if (n1 == 0)
                    return false;
                long n2 = stack.peek()[0];
                stack.pop();
                stack.push(new long[] {n2/n1});
			}
			else if ("MOD".equals(currList[0])) {
                if (stack.size() < 2)
                    return false;
                long n1 = stack.peek()[0];
                stack.pop();
                if (n1 == 0)
                    return false;
                long n2 = stack.peek()[0];
                stack.pop();
                stack.push(new long[] {n2%n1});
			}
		}
		if(stack.size()==1)
			return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		list = new ArrayList<>();
		stack = new Stack<>();
		
		while(true) {
			//프로그램 영역
			String cmd;
			while(true) {
				st = new StringTokenizer(br.readLine());
				cmd = st.nextToken();
				
				//NUM일 경우 공백을 기준으로 입력받기
				if(cmd.equals("NUM")) {
					String n = st.nextToken();
					list.add(new String[] {cmd, n});
				}
				//QUIT or END 이면 루프 탈
				else if(cmd.equals("QUIT")||cmd.equals("END")) 
					break;
				
				else 
					list.add(new String[] {cmd});
			}
			if(cmd.equals("QUIT"))
				break;
			
			//입력 영역
			int N = Integer.parseInt(br.readLine());
			for(int n=0;n<N;n++) {
				long num = Long.parseLong(br.readLine());
				
				if(run(num)) {
					if(stack.peek()[0]>limit)
						System.out.println("ERROR");
					else
						System.out.println(stack.pop()[0]);
				}
				else
					System.out.println("ERROR");
				
				while(!stack.isEmpty())
					stack.pop();
			}
			list.clear();
			br.readLine();
			System.out.println();
		}
	}
}
