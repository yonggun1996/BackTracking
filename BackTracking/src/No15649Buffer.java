import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No15649Buffer {
	
	static boolean visit[];
	static int m;
	static int n;
	
	public static void backtracking(int[] number, int index) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if(index != n) {
			for(int i = 1; i <= m; i++) {
				if(!visit[i - 1]) {
					number[index] = i;
					visit[i - 1] = true;//방문 했다는걸 표시
					index++;
					backtracking(number, index);
					index--;//해당 위치에 다른 데이터를 넣기 위해 감소
					visit[i - 1] = false;//다음번에도 다시 방문하기위해 false로 초기화
				}
			}//for
		}else {
			for(int i : number) {
				//System.out.print(i + " ");
				bw.write(String.valueOf(i) + " ");
			}
			bw.newLine();
			bw.flush();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		int[] number = new int[n];
		visit = new boolean[m];
		
		for(int i = 1; i <= m; i++) {
			number[0] = i;
			visit[i - 1] = true;
			backtracking(number, 1);
			visit[i - 1] = false;
		}
		
	}

}
