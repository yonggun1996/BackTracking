import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No9663Buffer {
	
	static int N;
	static int count;
	static No9663Buffer m = new No9663Buffer();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		int[][] visit_available_array = new int[N][N];
		
		for(int x = 0; x < N; x++) {
			visit_available_array[0][x]++;
			m.upper_space_increase(x, 1 , visit_available_array);
			m.left_diagonal_increase(x - 1, 1, visit_available_array);
			m.right_diagonal_increase(x + 1, 1, visit_available_array);
			m.backtracking(1, visit_available_array);
			m.upper_space_reduce(x, 1, visit_available_array);
			m.left_diagonal_reduce(x - 1, 1, visit_available_array);
			m.right_diagonal_reduce(x + 1, 1, visit_available_array);
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		
	}
	
	public void backtracking(int y, int[][] visit_available_array) {
		if(y == N) {
			count++;
		}else {
			for(int x = 0; x < N; x++) {
				if(visit_available_array[y][x] == 0) {
					visit_available_array[y][x]++;
					m.upper_space_increase(x, y + 1, visit_available_array);
					m.left_diagonal_increase(x - 1, y + 1, visit_available_array);
					m.right_diagonal_increase(x + 1, y + 1, visit_available_array);
					m.backtracking(y + 1, visit_available_array);
					visit_available_array[y][x]--;
					m.upper_space_reduce(x, y + 1, visit_available_array);
					m.left_diagonal_reduce(x - 1, y + 1, visit_available_array);
					m.right_diagonal_reduce(x + 1, y + 1, visit_available_array);
				}
			}
		}
	}
	
	//체스 놓인칸에 위쪽으로 갈 수 있는 수를 늘린다
	public void upper_space_increase(int x, int y, int[][] visit_available_array) {
		for(; y < N; y++) {
			visit_available_array[y][x]++;
		}
	}
	
	//체스 놓인칸에 왼쪽 대각선으로 갈 수 있는 수를 늘린다
	public void left_diagonal_increase(int x, int y, int[][] visit_available_array){
		while(x >= 0 && y < N) {
			visit_available_array[y][x]++;
			x--;
			y++;
		}
	}
	
	//체스 놓인칸에 오른쪽 대각선으로 갈 수 있는 수를 늘린다
	public void right_diagonal_increase(int x, int y, int[][] visit_available_array){
		while(x < N && y < N) {
			visit_available_array[y][x]++;
			x++;
			y++;
		}
	}
	
	//체스 놓인칸에 위쪽으로 갈 수 있는 수를 줄인다
	public void upper_space_reduce(int x, int y, int[][] visit_available_array) {
		for(; y < N; y++) {
			visit_available_array[y][x]--;
		}
	}
	
	//체스 놓인칸에 왼쪽 대각선으로 갈 수 있는 수를 줄인다
	public void left_diagonal_reduce(int x, int y, int[][] visit_available_array){
		while(x >= 0 && y < N) {
			visit_available_array[y][x]--;
			x--;
			y++;
		}
	}
	
	//체스 놓인칸에 오른쪽 대각선으로 갈 수 있는 수를 줄인다
	public void right_diagonal_reduce(int x, int y, int[][] visit_available_array){
		while(x < N && y < N) {
			visit_available_array[y][x]--;
			x++;
			y++;
		}
	}
	
}