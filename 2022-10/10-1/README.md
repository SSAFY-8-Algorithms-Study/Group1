## 10주차 회의록 

:calendar: : 9 PM, 22.10.04(TUE)

### :loudspeaker: 공지사항

### :heavy_check_mark: 개인 별 미션 달성도 :x:
|Problem No.|3187|11403|2624|8982|17143|
|:-----------:|:-----:|:----:|:----:|:----:|:----:|
|최현인|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|
|김승희|:heavy_check_mark:|:heavy_check_mark:|:x:|:x:|:heavy_check_mark:|
|백자민|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|:x:|:heavy_check_mark:|
|한재욱|:heavy_check_mark:|:heavy_check_mark:|:x:|:x:|:heavy_check_mark:|

### :bookmark_tabs: 코드 리뷰

#### 3187 양치기 꿍

- 코드 리뷰 : 한재욱
  - 핵심 기법 : BFS
  - 풀이 방법 
    - 방문하지 않은 곳이며, 울타리가 아닌 지점에서 bfs탐색해서 울타리가 나눈 영역을 구하고 양의 수(v) 늑대의수(k)수를 탐색하면서 count해서 양이 많으면 양이 살아남고 늑대가 남으면 늑대가 살아남게한후 늑대와 양의 수를 출력.


#### 11403 경로 찾기

- 코드 리뷰 : 김승희
  - 핵심 기법 : 플로이드 워셜
  - 풀이 방법 
    - 플로이드 워셜 알고리즘 사용
    - D 배열의 값이 Integer.MAX_VALUE라면 경로가 없는 것.
    


#### 2624 동전 바꿔주기

- 코드 리뷰 : 백자민
  - 핵심 기법 : DP, Knapsack
  - 풀이 방법
    -  knapsack 알고리즘을 사용하여 해당 금액을 만들 수 있는 가짓수를 계산한다.
    - 만약 금액의 합이 T를 초과한다면 가짓수를 갱신하지 않는다. 
    - 마지막으로 해당 금액이 나왔을 경우의 가짓수를 출력한다. 
    

#### 8982 수족관

- 코드 리뷰 : 최현인
  - 핵심 기법 : 구현, 시뮬레이션
  - 풀이 방법 
    - 수평 선분들을 객체로 만들어서 배열로 저장한 뒤에
    - 구멍이 난 수평선분을 기준으로 다른 수평 선분들과 비교하며 해당 선분 위에 물의 양을 줄여 나간다
    - 시뮬레이션 문제이다 보니 꼼꼼하게 문제를 읽고 조건들을 추가해 주어야 한다
    - 가장 마지막에 비교한 높이를 기록해서 물의 높이를 조절 한다.

### :raising_hand_man: 건의 사항 :raising_hand:

