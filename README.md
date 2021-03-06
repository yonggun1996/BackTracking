# 백준 알고리즘 백트래킹 문제 풀이

##백트래킹 : 답을 찾아가는 과정중에서 추후에 값이 유망하지 않다면 이전 단계로 돌아와 다시 값을 찾아 완전한 값을 구하는 알고리즘 입니다.

## 각종 N과 M문제

### 이 문제는 백트래킹 입문 문제들로 숫자 하나가 주어질 때 각각의 경우의 수 들을 구하는 문제입니다.

1. 중복되지 않는 한에서 모든 경우의 수를 보여주는 문제
  - main 메소드에서 배열 0번째 인덱스를 1부터 입력받은 수 까지 입력합니다.
  - backtracking 메소드에서 배열에 들어갈 값들을 채웁니다. 단 n-1번째 배열과 겹치면 안됩니다.
  - 받으려는 파라미터는 데이터를 담은 number 배열과 어디 인덱스에 담는지 알려주는 index(int형 변수)를 파라미터로 받습니다. 
  - 자세한 풀이를 쓴 블로그 : https://blog.naver.com/qkrdydrjs7/222235873245 

2. 오름차순이 되는 조건 하에 모든 경우의 수를 보여주는 문제
  - 이 문제는 1번 사항과 비슷하지만 index - 1 인덱스의 데이터가 index 데이터보다 크면 배열에 삽입하지 않는 if문을 이용해 풀었습니다.
  - 자세한 풀이를 쓴 블로그 : https://blog.naver.com/qkrdydrjs7/222244636713
  
3. 중복되는 값, 오름차순과 상관없이 모든 경우의 수를 보여주는 문제
  - 1,2번 문제는 visit배열을 만들어 같은 조건에 맞게 들어올 수 없는 수는 visit함수를 통해 들어오지 않게 했지만 
    이번 문제는 visit배열을 생성하지 않아 모든 원소들이 들어올 수 있게 했습니다.
  - 자세한 풀이를 쓴 블로그 : https://blog.naver.com/qkrdydrjs7/222249580435
  
4. 뒤에 인덱스 값이 앞에 인덱스 값보다 크거나 같은 수만 들어올 수 있게 하는 문제
  - 자세한 풀이를 쓴 블로그 : https://blog.naver.com/qkrdydrjs7/222252882197
  
## N - Queen 문제

### 이 문제는 체스판에 Queen만 놓으려고 할 때 서로 공격반경에 들지 않는 경우의 수가 몇 개인지 출력하는 문제입니다.

이 문제는 수가 하나(n 이라고 가정) 주어질 때 n*n의 배열을 만들고 0번째 줄 부터 0번째 칸에 퀸 을 놓은 후 해당 공격반경을 체크합니다.
그 뒤로는 다음 줄로 올라가 아랫줄의 공격반경을 제외한 칸에 퀸을 놓습니다. 만약 퀸을 놓을 곳이 없으면 이전 줄로 돌아갑니다.
마지막 줄에 퀸을 놨다면 카운트를 늘립니다.
-자세한 풀이를 쓴 블로그 : https://blog.naver.com/qkrdydrjs7/222252903491

## 스도쿠 문제

### 이 문제는 스도쿠에서 0이 빈칸일 때 0에 들어갈 수 있는 경우의 수를 한 가지만 출력하는 문제입니다.

0이 담겨있는 인덱스로 들어가 가로줄, 세로줄, 3*3지역에 담긴 수를 제외하고 제일 작을 수를 담습니다.
만약 1부터 9 중에서도 담을 수가 없다면 이전칸으로 돌아와 담을 수 있는 수를 늘립니다.
마지막 부분(9행 9열)까지 왔으면 모두 출력한 후 exit(0)으로 프로그램을 끝냅니다.

자세한 풀이를 쓴 블로그 : https://blog.naver.com/qkrdydrjs7/222252903491

## 연산자 끼워넣기 문제

### 이 문제는 수들이 차례로 주어지고 연산 수가 주어질 때 연산을 할 최대값과, 최소값을 구하는 문제입니다.

주어진 연산개수를 토대로 연산 순서들을 담습니다.
그리고 주어진 수열에 따라 연산을 해서 배열에 담습니다.
그 후 배열을 정렬해 최소값과(맨 왼쪽 인덱스) 최대값(맨 오른쪽 인덱스)을 출력합니다.

자세한 풀이를 쓴 블로그 : https://blog.naver.com/qkrdydrjs7/222259084681

## 스타트와 링크

### 이 문제는 두 사람의 조합 능력치가 배열로 주어진 상황에서 팀을 짰을 때 가장 차이가 적은 수를 구하는 문제입니다.

우선 팀을 어떨게 나눌 수 있는지 모든 경우의 수를 구합니다. (단 앞에 1만 있는 상황에서 모든 경우의 수를 돈다면 시간을 줄일 수 있습니다.)
그 다음 팀 내에 두 사람의 능력치를 배열에서 찾아내 팀원들의 시너지 합을 더합니다.
두 팀의 총 시너지를 구하면 빼서 출력합니다.

자세한 풀이를 쓴 블로그 : https://blog.naver.com/qkrdydrjs7/222266844200
