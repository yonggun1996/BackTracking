package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No18430 {
    static int n;
    static int m;
    static int answer = 0;
    static int[][] tree;//주어진 나무의 강도
    static boolean[][] use_Tree;//해당 나무 구역을 썻는지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new int[n][m];
        use_Tree = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(n == 1 || m == 1){//틀을 짤 수 없는 경우 0을 출력하고 프로그램을 끝낸다
            System.out.println("0");
            return;
        }

        search(0,0,0);
        System.out.println(answer);
    }

    //맨 좌측 상단에서 부터 맞는 틀이 생기면 오른쪽으로 한칸씩 이동
    //맨 오른쪽으로 오면 다시 아래로 다 탐색하면 answer를 갱신
    //처음에는 3중 for문이 됐는데 이 부분은 상당히 비효율적
    static void search(int x, int y, int result){
        if(y + 2 > m){//y가 범위를 벗어날 경우
            x++;
            y = 0;
        }

        if(x + 2 > n){//x가 범위를 벗어날 경우 여태 더한 값과 비교해최대값을 구한다
            answer = Math.max(answer, result);
            return;
        }

        //부메랑 틀 1을 맞출때 맞춘 공간이 없다면
        if(!use_Tree[x][y] && !use_Tree[x][y + 1] && !use_Tree[x + 1][y + 1]){
            int nresult = result + tree[x][y] + tree[x + 1][y + 1] + (tree[x][y + 1] * 2);//문제에서 나온 강도 연산
            use_Tree[x][y] = true;
            use_Tree[x][y + 1] = true;
            use_Tree[x + 1][y + 1] = true;
            search(x, y + 1, nresult);
            use_Tree[x][y] = false;
            use_Tree[x][y + 1] = false;
            use_Tree[x + 1][y + 1] = false;
        }

        //부메랑 틀 2을 맞출때 맞춘 공간이 없다면
        if(!use_Tree[x][y + 1] && !use_Tree[x + 1][y] && !use_Tree[x + 1][y + 1]){
            int nresult = result + tree[x][y + 1] + tree[x + 1][y] + (tree[x + 1][y + 1] * 2);//문제에서 나온 강도 연산
            use_Tree[x][y + 1] = true;
            use_Tree[x + 1][y] = true;
            use_Tree[x + 1][y + 1] = true;
            search(x, y + 1, nresult);
            use_Tree[x][y + 1] = false;
            use_Tree[x + 1][y] = false;
            use_Tree[x + 1][y + 1] = false;
        }

        //부메랑 틀 3을 맞출때 맞춘 공간이 없다면
        if(!use_Tree[x][y] && !use_Tree[x + 1][y] && !use_Tree[x + 1][y + 1]){
            int nresult = result + tree[x][y] + tree[x + 1][y + 1] + (tree[x + 1][y] * 2);//문제에서 나온 강도 연산
            use_Tree[x][y] = true;
            use_Tree[x + 1][y] = true;
            use_Tree[x + 1][y + 1] = true;
            search(x, y + 1, nresult);
            use_Tree[x][y] = false;
            use_Tree[x + 1][y] = false;
            use_Tree[x + 1][y + 1] = false;
        }

        //부메랑 틀 4을 맞출때 맞춘 공간이 없다면
        if(!use_Tree[x][y] && !use_Tree[x + 1][y] && !use_Tree[x][y + 1]){
            int nresult = result + tree[x + 1][y] + tree[x][y + 1] + (tree[x][y] * 2);//문제에서 나온 강도 연산
            use_Tree[x][y] = true;
            use_Tree[x + 1][y] = true;
            use_Tree[x][y + 1] = true;
            search(x, y + 1, nresult);
            use_Tree[x][y] = false;
            use_Tree[x + 1][y] = false;
            use_Tree[x][y + 1] = false;
        }

        search(x, y + 1, result);//아무것도 선택하지 않는 경우도 포함
    }
}