package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10971 {
    static int n;
    static int[][] board;//입력받은 board
    static boolean[] visit;//해당 도시를 방문한 적 있는지 체크하는 배열
    static int answer = Integer.MAX_VALUE;//정답이 될 변수, 항상 순회할 수 있는 경우만 주어지기 때문에 최대값으로 설정해도 문제 없음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visit = new boolean[n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            DFS(i, i, 0,0);
        }

        System.out.print(answer);//계속해서 순회하면서 수정한 최소값을 출력한다
    }

    //백트래킹을 하면서 순회를 시작한다.
    static void DFS(int start, int now, int result, int visit_Count){
        if(visit_Count == n){//모든 경로를 순회했을 경우
            answer = Math.min(answer, result);//최소값으로 변경
        }else if(visit_Count == n - 1){//출발지 빼고 다 순회했으면 시작지점으로 향한다
            if(board[now][start] > 0){//단 길이 있을 때 순회한다
                DFS(start, start, result + board[now][start], visit_Count + 1);
            }
        }else{
            for(int i = 0; i < n; i++){
                //다음 지역에 방문하지 않았고, 시작지점이 아니고, 길이 있다면 DFS를 실행한다
                if(!visit[i] && i != start && board[now][i] > 0){
                    visit[i] = true;//방문처리
                    DFS(start, i, result + board[now][i], visit_Count + 1);//재귀함수 호출
                    visit[i] = false;
                }
            }
        }
    }
}
