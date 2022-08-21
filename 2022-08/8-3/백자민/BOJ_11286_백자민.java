package week8_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286_백자민 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((n1, n2)->{
			int abs1 = Math.abs(n1);
			int abs2 = Math.abs(n2);
			
			if(abs1==abs2) return n1>n2 ? 1:-1;
			return abs1-abs2;
		});
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num != 0) {
				q.add(num);
			}
			else {
				if(q.isEmpty())
					System.out.println(0);
				else
					System.out.println(q.poll());
			}
				
		}
	}
}
