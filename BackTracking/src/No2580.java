import java.util.Scanner;

public class No2580 {
	
	static int[][] sdokoo_array = new int[9][9];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sdokoo_array[i][j] = in.nextInt();
			}
		}
		
		search(0, 0);
	}
	
	public static void search(int x, int y){
		if(x == 9 || y == 9) {
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					//System.out.print(sdokoo_array[i][j] + " ");
				}
			}
			
			System.exit(0);
		}else {
			if(sdokoo_array[x][y] == 0) {
				boolean[] Visitable_array = {true, true, true, true, true, true, true, true, true};
				
				//���ο� �ִ� ������ Ȯ��
				for(int i = 0; i < 9; i++) {
					if(sdokoo_array[x][i] != 0) {
						int index = sdokoo_array[x][i] - 1;
						Visitable_array[index] = false;
					}
				}
				
				//���ο� �ִ� ������ Ȯ��
				for(int i = 0; i < 9; i++) {
					if(sdokoo_array[i][y] != 0) {
						int index = sdokoo_array[i][y] - 1;
						Visitable_array[index] = false;
					}
				}
				
				//3*3 �簢���� �ִ� ������ Ȯ��
				int i_start = 0;
				int i_end = 0;
				int j_start = 0;
				int j_end = 0;
				
				if(x >= 0 && x <= 2) {
					i_start = 0;
					i_end = 2;
				}else if(x >= 3 && x <= 5) {
					i_start = 3;
					i_end = 5;
				}else if(x >= 6 && x <= 8) {
					i_start = 6;
					i_end = 8;
				}
				
				if(y >= 0 && y <= 2) {
					j_start = 0;
					j_end = 2;
				}else if(y >= 3 && y <= 5) {
					j_start = 3;
					j_end = 5;
				}else if(y >= 6 && y <= 8) {
					j_start = 6;
					j_end = 8;
				}
				
				for(int i = i_start; i <= i_end; i++) {
					for(int j = j_start; j <= j_end; j++) {
						if(sdokoo_array[i][j] != 0) {
							int index = sdokoo_array[i][j] - 1;
							Visitable_array[index] = false;
						}
					}
				}
				
				//�ƹ� ���ڵ� �� ������ ������Ȳ���� �ٽ� ���ư���
				int false_count = 0;
				
				for(int i = 0; i < 9; i++) {
					if(!Visitable_array[i]) {
						false_count++;
					}
				}
				
				if(false_count < 9) {
					for(int i = 0; i < 9; i++) {
						if(Visitable_array[i]) {//���� �� �ִ� ���ڴ� ���´�
							sdokoo_array[x][y] = i + 1;
							
							if(y == 8) {
								x++;
								y = 0;
								search(x,y);
								
								//�� �κ��� �־�� ���� �ִ� �ڸ��� ���󺹱��� �ȴ�
								x--;
								y = 8;
								sdokoo_array[x][y] = 0;
							}else {
								y++;
								search(x,y);
								
								//�� �κ��� �־�� ���� �ִ� �ڸ��� ���󺹱��� �ȴ�
								y--;
								sdokoo_array[x][y] = 0;
							}
						}
					}
				}
				
			}else {//0�� �ƴѰ��� ������ ��
				if(y == 8) {
					x++;
					y = 0;
					search(x,y);
				}else {
					y++;
					search(x,y);
				}
			}
			
		}
		
	}

}
