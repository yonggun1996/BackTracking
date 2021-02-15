import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No15650Buffer {
	
	static int m;
	static int n;
	static boolean[] visit;
	
	public static void backtracking(int[] answer_array, int index) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		if(index < n) {
			for(int i = 0; i < m; i++) {
				if(!visit[i]) {
					if(answer_array[index - 1] < i + 1) {
						answer_array[index] = i + 1;
						visit[i] = true;
						backtracking(answer_array, index + 1);
						visit[i] = false;
					}
				}
				
			}
		}else {
			for(int i : answer_array) {
				bw.write(String.valueOf(i) + " ");
			}
			bw.newLine();
			bw.flush();
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		visit = new boolean[m];
		int[] answer_array = new int[n];
		
		for(int i = 1; i <= m; i++) {
			answer_array[0] = i;
			visit[i - 1] = true;
			backtracking(answer_array, 1);
		}
	}

}
