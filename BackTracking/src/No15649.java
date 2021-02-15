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
					visit[i - 1] = true;//�湮 �ߴٴ°� ǥ��
					index++;
					backtracking(number, index);
					index--;//�ش� ��ġ�� �ٸ� �����͸� �ֱ� ���� ����
					visit[i - 1] = false;//���������� �ٽ� �湮�ϱ����� false�� �ʱ�ȭ
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
		m = in.nextInt();//���� ���ڵ�
		n = in.nextInt();//�迭 ����
		
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
