import java.util.Scanner;

public class No15649 {
	
	static boolean visit[];
	static int m;
	static int n;
	
	public static void backtracking(int[] number, int index) {
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
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		m = in.nextInt();//나올 숫자들
		n = in.nextInt();//배열 길이
		
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
