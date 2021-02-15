import java.util.Scanner;

public class No15650 {
	
	static int m;
	static int n;
	static boolean[] visit;
	
	public static void backtracking(int[] answer_array, int index) {
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
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		m = in.nextInt();
		n = in.nextInt();
		visit = new boolean[m];
		int[] answer_array = new int[n];
		
		for(int i = 1; i <= m; i++) {
			answer_array[0] = i;
			visit[i - 1] = true;
			backtracking(answer_array, 1);
		}
	}

}
