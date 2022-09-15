import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int N;
	static ArrayList<Integer>[] Graph;
	static int Map[];
	static boolean ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		while (N != 0) {
			Map = new int[N];
			Graph = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				Graph[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < N; i++) {
				String[] inArr = br.readLine().split(" ");
				int m = Integer.parseInt(inArr[1]);
				if (inArr[0].equals("L")) {
					Map[i] = m;
				} else if (inArr[0].equals("T")) {
					Map[i] = -m;
				}
				for (int j = 2; j < inArr.length - 1; j++) {
					Graph[i].add(Integer.parseInt(inArr[j]) - 1);
				}
			}
			ans = false;
			DFS(0, 0, new boolean[N]);
			if(ans) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
			N = Integer.parseInt(br.readLine());
		}

	}

	public static void DFS(int n, int belonging, boolean[] visit) {
		if(ans) return;
		int nBelonging = belonging;
		if (Map[n] > 0) { // L
			nBelonging = Math.max(Map[n], nBelonging);
		} else if (Map[n] < 0) { // T
			if (-Map[n] > nBelonging) {
				return;
			}
			nBelonging += Map[n];
		}
		visit[n] = true;
		if (n == N - 1) {
			for(int i = 0; i < N; i++) {
				if(!visit[i]) {
					return;
				}
			}
			ans = true;
			return;
		}
		for (int i = 0; i < Graph[n].size(); i++) {
			if(visit[Graph[n].get(i)]) {
				continue;
			}
			DFS(Graph[n].get(i), nBelonging, visit);
		}

	}

}
