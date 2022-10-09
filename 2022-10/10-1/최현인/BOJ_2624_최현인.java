package boj;

// 2624 동전 바꿔주기
// 동전을 사용해서 만들 수 있는 경우를 조합으로 구하기에는 동전의 가지 수가 너무 많다
// 따라서 완전 탐색은 불가능한 문제이며 점진적으로 증가하는 형태를 가지고 있기 때문에 DP로 접근하였다
// 2차원 배열 DP를 사용하였고, 작은 단위의 동전부터 기록해나가야 DP를 만들 수 있기 때문에 입력 동전을 정렬하여 접근
// 모든 동전에 대하여 자기 자신보다 한 단계 작은 단위의 동전을 자기 자신과 만들어 낼 수 있는 경우를 기록해나간다.
// 최종적으로 가장 큰 단위의 동전으로 만들 수 있는 경우가 이전 경우를 모두 더한 값을 가지므로 답이 된다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    // 동전을 동전의 단위와 개수를 저장할 수 있도록 추상화 시킨다.
    static class coin implements Comparable<coin>{
    	int p, n; //p는 단위, n은 개수

		public coin(int p, int n) {
			this.p = p;
			this.n = n;
		}

		@Override
		public int compareTo(coin o) {
			return this.p-o.p;
		}
    	
    }
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	int K = Integer.parseInt(br.readLine());
    	
    	ArrayList<coin> coins = new ArrayList<>();
    	
    	for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			coins.add(new coin(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
    	// 작은 단위의 동전부터 계산하기 위해 정렬
    	Collections.sort(coins);
    	
    	// 2차원 DP를 사용, 각 행은 지금까지 사용한 동전의 단위, 의미 열은 만들 수 있는 금액을 의미한다.
    	int[][] dp = new int[K][T+1];
    	
    	// 각 동전을 자기 자신만 사용해서 만들 수 있는 금액을 기록
    	for (int i = 0; i < K; i++) {
			for (int j = 1; j <= coins.get(i).n; j++) {
				// 현재 금액이 찾고자하는 금액보다 클 경우 반복을 종료
				if (coins.get(i).p * j > T) { 
					break;
				}
				// 자기 자신으로만 만들 수 있는 금액에 대해 기록해준다. 1가지 경우가 되는 것이므로 1을 기록
				dp[i][coins.get(i).p*j] = 1;
			}
		}

    	// 현재 동전 i, 두 번째 동전부터 이전 동전과 비교를 한다. 
    	for (int i = 1; i <= K; i++) {
    		// 현재 금액 j, 1부터 찾고자 하는 금액까지 검사
			for (int j = 1; j <= T; j++) {
				// 이전 동전으로 현재 금액까지 만들었던 경우의 수를 더해준다.
				dp[i][j] += dp[i-1][j];
				
				// 현재 금액을 현재 동전을 더해서 만들 수 있는 경우의 수를 더해준다.
				// 현재 동전의 사용개수 k, 현재 동전의 개수로 만들 수 있는 모든 경우에 대해 검사
				for (int k = 1; k <= coins.get(i).n; k++) {
					//현재 금액에 (현재 동전의 금액 * 사용한 개수)를 빼준 금액을 이전 동전으로 만들 었던 결과 가져오기 위함
					int prev = j-coins.get(i).p*k;
					
					// prev 가 0보다 작다는 것은 (현재 동전의 금액 * 사용한 개수)가  현재 금액 보다 크다는 것, 반복을 멈춘다.
					if (prev < 0) { 
						break;
					}
					
					// prev 금액을 이전 동전까지 사용해서 만들 었던 경우의 수를 현재 금액을 만들 수 있는 경우의 수에 더해준다.
					dp[i][j] += dp[i-1][prev];
				}
			}
		}
    	
    	// 제일 큰 동전까지 사용해서 현재금액을 만들 수 있는 경우의 수가 답이 된다.
    	System.out.println(dp[K-1][T]);

    }
    
}