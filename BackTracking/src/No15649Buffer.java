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
					visit[i - 1] = true;//�湮 �ߴٴ°� ǥ��
					index++;
					backtracking(number, index);
					index--;//�ش� ��ġ�� �ٸ� �����͸� �ֱ� ���� ����
					visit[i - 1] = false;//���������� �ٽ� �湮�ϱ����� false�� �ʱ�ȭ
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
