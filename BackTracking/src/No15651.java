import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No15651 {
	
	static int m;
	static int n;
	static StringBuilder answer = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void backtracking() throws IOException {
		if(answer.length() < n * 2) {
			for(int i = 1; i <= m; i++) {
				answer.append(i + " ");
				backtracking();
				answer.delete(answer.length() - 2, answer.length());
			}
		}else {
			bw.write(answer.toString());
			bw.newLine();
		}
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= m; i++) {
			answer.append(i + " ");
			backtracking();
			answer.delete(0,answer.length());
		}
		
		bw.flush();
		
		
	}

}
