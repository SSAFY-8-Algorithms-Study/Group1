package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1956 운동
// BFS로 풀다가,, 두번 건너서 돌아오는 경우가 체크가 안돼서
// 체크 늘려보니까 시간초과남..
// 결국 플로이드 워셜로 풀었음
public class Main {
    static final int INF = 1000000000;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
 
        int[][] arr = new int[V + 1][V + 1];
 
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }
 
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
          
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
 
        // 플로이드 와샬 알고리즘 수행
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (i == j) {
                        continue;
                    }
 
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        int ans = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i][j] != INF && arr[j][i] != INF) {
                	//i->j가 가능하고 j->i가 가능 할 때, 시작점으로 돌아오는 길이를 알 수 있으므로 최솟값 초기화
                    ans = Math.min(ans, arr[i][j] + arr[j][i]);
                }
            }
        }
        System.out.println((ans == INF) ? -1 : ans);
    }
}