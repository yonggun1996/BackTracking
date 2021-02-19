import java.util.Scanner;

public class No15652 {
	
	static int m;
	static int n;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		m = in.nextInt();
		n = in.nextInt();
		
		visit = new boolean[m];
		int[] answer_array = new int[n];
		
		for(int i = 1; i <= m; i++) {
			answer_array[0] = i;
			backtracking(1, answer_array);
			visit[i - 1] = true;
		}
	}
	
	public static void backtracking(int index, int[] answer_array) {
		if(index < n) {
			for(int i = 0; i < m; i++) {
				if(!visit[i] && answer_array[index - 1] <= i + 1) {
					answer_array[index] = i + 1;
					//visit[i] = true;
					backtracking(index + 1, answer_array);
					visit[i] = false;
				}
			}
		}else {
			
			for(int i = 0; i < n; i++) {
				System.out.print(answer_array[i] + " ");
			}
			System.out.println();
			
		}
	}

}
