import java.util.Scanner;

public class No9663 {
	
	static int N;
	static int count;
	static No9663 m = new No9663();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
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
		
		System.out.println(count);
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
	
	//ü�� ����ĭ�� �������� �� �� �ִ� ���� �ø���
	public void upper_space_increase(int x, int y, int[][] visit_available_array) {
		for(; y < N; y++) {
			visit_available_array[y][x]++;
		}
	}
	
	//ü�� ����ĭ�� ���� �밢������ �� �� �ִ� ���� �ø���
	public void left_diagonal_increase(int x, int y, int[][] visit_available_array){
		while(x >= 0 && y < N) {
			visit_available_array[y][x]++;
			x--;
			y++;
		}
	}
	
	//ü�� ����ĭ�� ������ �밢������ �� �� �ִ� ���� �ø���
	public void right_diagonal_increase(int x, int y, int[][] visit_available_array){
		while(x < N && y < N) {
			visit_available_array[y][x]++;
			x++;
			y++;
		}
	}
	
	//ü�� ����ĭ�� �������� �� �� �ִ� ���� ���δ�
	public void upper_space_reduce(int x, int y, int[][] visit_available_array) {
		for(; y < N; y++) {
			visit_available_array[y][x]--;
		}
	}
	
	//ü�� ����ĭ�� ���� �밢������ �� �� �ִ� ���� ���δ�
	public void left_diagonal_reduce(int x, int y, int[][] visit_available_array){
		while(x >= 0 && y < N) {
			visit_available_array[y][x]--;
			x--;
			y++;
		}
	}
	
	//ü�� ����ĭ�� ������ �밢������ �� �� �ִ� ���� ���δ�
	public void right_diagonal_reduce(int x, int y, int[][] visit_available_array){
		while(x < N && y < N) {
			visit_available_array[y][x]--;
			x++;
			y++;
		}
	}
	
}
