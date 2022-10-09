package boj;

// 8982 수족관
// 수평 선분들을 객체로 만들어서 배열로 저장한 뒤에
// 구멍이 난 수평선분을 기준으로 다른 수평 선분들과 비교하며 해당 선분 위에 물의 양을 줄여 나간다
// 시뮬레이션 문제이다 보니 꼼꼼하게 문제를 읽고 조건들을 추가해 주어야 한다
// 가장 마지막에 비교한 높이를 기록해서 물의 높이를 조절 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	// 수평 선분을 추상화, 객체로 만들어서 접근
    static class spot{ 
    	int l, r, w, depth; 
    	// l : 선분의 왼쪽 끝 인덱스, r: 선분의 오른쪽 끝 인덱스, w : 해당 선분 위에 남아있는 물의 양
    	// depth : 수족관의 가장 위로 부터 해당 선분의 깊이

		public spot(int l, int r, int w, int depth) {
			this.l = l;
			this.r = r;
			this.w = w;
			this.depth = depth;
		}
    }
    // 수평 선분들을 이용하여 수족관을 배열로 저장
 	static ArrayList<spot> aqua;
 	// 가장 최근에 비교한 깊이를 저장할 배열 lateDepth
 	static int[] lateDepth;
    public static void main(String[] args) throws IOException {    
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	// 수평 선분들을 이용하여 수족관을 배열로 저장
    	aqua = new ArrayList<>();
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for (int i = 0; i < (N-2)/2; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int depth = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			aqua.add(new spot(l, r, (r-l)*depth, depth));
		}
    	st = new StringTokenizer(br.readLine());
    	
    	int K = Integer.parseInt(br.readLine());
    	    	
    	// 가장 최근 비교한 깊이 배열의 초기값은 가장 낮은 깊이인 0
		lateDepth = new int[aqua.size()];
		
    	// 구멍이 하나씩 생긴다고 가정하고 시뮬레이션을 돌려봄
    	for (int i = 0; i < K; i++) {
    		// 현재 구멍 입력 받기, 구멍이 생긴 선분을 입력으로 주기 때문에
    		// aqua 배열에서 해당 선분을 찾기 위해 좌측 좌표만 가져온다
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			
			// 해당 구멍이 생긴 선분의 위치를 찾는다.
			int idx = findHole(L);
			
			// 찾은 선분에 구멍이 생겼으므로 해당 선분 위에 남은 물의 양은 0
			aqua.get(idx).w = 0;
			// 현재 깊이를 저장한다, 
			int tempDepth = aqua.get(idx).depth;
			// 최근에 비교한 깊이를 저장해주는데, 
			// 더 낮은 깊이는 비교하는 의미가 없으므로 더 깊은 깊이일 때만 저장해준다.
			lateDepth[idx] = Math.max(tempDepth, lateDepth[idx]);
			
			// 찾은 위치를 기준으로 우측 선분들 탐색
			compareDepth(tempDepth, idx, 1);
			// 찾은 위치를 기준으로 좌측 선분들 탐색
			compareDepth(tempDepth, idx, -1);
		}
    	
    	int answer = 0;
    	for (int i = 0; i < aqua.size(); i++) {
			answer += aqua.get(i).w; 
		}
    	System.out.println(answer);
    	
    }
    public static int findHole(int L) {
    	// 배열을 돌면서 선분을 찾아나감
		for (int j = 0; j < aqua.size(); j++) {
			// 입력이 반시계 방향으로 들어왔으므로
			// 현재 선분의 좌측 끝 좌표와 찾고자하는 선분의 좌측 끝 좌표를 비교한다
			// 좌측 끝 좌표가 같은 값을 찾았으면
			if (aqua.get(j).l == L) {
				return j; // 인덱스 값을 반환
			}
		}
		return 0;
    }
    public static void compareDepth(int tempDepth, int idx, int dx) {
    	// 구멍이 생긴 선분 기준으로 다음 선분 부터 검사
    	idx += dx;
    	// idx가 수족관 범위 안에 있을 때 반복, 우측하고 좌측을 탐색하기 위해 dx 사용
    	while(idx >= 0 && idx < aqua.size()) {
    		// 가장 최근에 검사한 깊이보다 현재 검사하고자 하는 깊이가 낮을 경우엔 검사할 필요가 없음, 다음 지점 검사
    		if (tempDepth <= lateDepth[idx]) {
				idx += dx;
    			continue;
			}
			// 수족관 idx 지점의 깊이가 현재 검사하고자 하는 깊이보다 낮거나 같으면
			if (aqua.get(idx).depth <= tempDepth) {
				// 더 낮은 지점에 구멍이 생긴 것이므로 idx 지점의 선분 위에 물은 다 빠져나간다.
				aqua.get(idx).w = 0;
				// 다음 지점을 검사할 때 부터는 idx 지점의 깊이로 검사를 한다.
				tempDepth = aqua.get(idx).depth;
			}
			// 수족관 idx 지점의 깊이가 현재 검사하고자 하는 깊이보다 깊으면
			else {
				//idx 지점의 선분 위에 남은 물의 양에서
				//[현재 검사하고자 하는 깊이]에서 [최근의 검사했던 깊이]를 빼준 값을 높이로 하는 양만큼 빼준다
				aqua.get(idx).w -= (aqua.get(idx).r-aqua.get(idx).l)*(tempDepth-lateDepth[idx]);
			}
			//최근 검사한 깊이를 현재 깊이 값으로 바꿔 준다.
			lateDepth[idx] = tempDepth;
			//다음 지점 검사
			idx += dx;
    	}
    }
}