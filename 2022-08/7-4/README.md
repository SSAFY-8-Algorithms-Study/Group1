# 1주차 회의록 

:calendar: : 9 PM, 22.07.31(SUN)

### :loudspeaker: 공지사항
- 온라인 스터디 신청 완료
- 스터디 보고서 작성

### :heavy_check_mark: 개인 별 미션 달성도 :x:
|Problem No.|1100|1059|1051|2468|2573|
|:-----------:|:-----:|:----:|:----:|:----:|:----:|
|최현인|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|
|김승희|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|
|백자민|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|
|한재욱|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|:heavy_check_mark:|:x:|

### :bookmark_tabs: 코드 리뷰

#### 2468 안전영역

- 코드 리뷰 : 백자민
  - 핵심 기법 : DFS
  - 풀이 방법 : 강수량을 1부터 층수가 가장 높은 건물까지만 고려함, 매 강수량 마다 강수량보다 높은 건물을 탐색 건물이 존재한다면, 해당 건물과 이어진 건물을 DFS로 탐색  
  - 피드백 : 메소드를 나눠서 구현한 부분이 좋았고 DFS의 시간초과를 우려하여 층수를 먼저 탐색한 것이 좋았음. 다만 탐색 범위가 더 넓었다면 해당 방법도 시간 초과의 우려가 있음. BFS로도 구현해보면 좋을 것 같음
#### 2573 빙산 
- 코드 리뷰 : 김승희
  - 핵심 기법 : BFS
  - 풀이 방법 : 빙하 주변을 탐색하여 빙하가 녹는 양을 좌표값과 함께 객체로 저장 후 배열에 담음. 해당 배열을 순회하며 빙하가 녹은 후의 모습으로 지도를 초기화. 마지막으로 현재 지도에서 빙하가 몇개 인지 BFS로 탐색
  - 피드백 : 문제에서 의도한 대로 잘 풀었고 복잡해질 수 있는 코드를 메소드로 나눠서 잘 구현 했음
#### 코드 리뷰 결과
- 탐색 문제에서 BFS를 활용하는 연습 필요
  
### :raising_hand_man: 건의 사항 :raising_hand:

- 스터디 멤버 매 월 변경 되는지 궁금합니다
  - 확인 후 빠른 시일 내에 공지 해드리겠습니다 
- 코드 리뷰가 끝나면 모두가 해당 풀이에 대한 피드백을 주면 좋을 것 같습니다