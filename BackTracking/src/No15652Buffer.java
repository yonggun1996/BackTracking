import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No15652Buffer {
	
	static int m;
	static int n;
	static boolean[] visit;
	static StringBuilder answer = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		
		visit = new boolean[m];
		
		for(int i = 1; i <= m; i++) {
			answer.append(i + " ");
			backtracking(0);
			visit[i - 1] = true;
			answer.delete(0, answer.length());
		}
		bw.flush();
	}
	
	public static void backtracking(int num) throws IOException {
		if(answer.length() < n * 2) {
			for(int i = 0; i < m; i++) {
				if(!visit[i] && answer.charAt(num) - '0' <= i + 1) {
					answer.append(i + 1 + " ");
					backtracking(num + 2);
					visit[i] = false;
					answer.delete(answer.length() - 2, answer.length());
				}
			}
		}else {
			bw.write(answer.toString());
			bw.newLine();
		}
	}

}
