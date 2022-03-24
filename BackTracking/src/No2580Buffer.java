import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No2580Buffer {
	
	static int[][] sdokoo_array = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				st = new StringTokenizer(br.readLine());
				sdokoo_array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		search(0, 0);
	}
	
	public static void search(int x, int y) throws IOException {
		if(x == 9 || y == 9) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					bw.write(String.valueOf(sdokoo_array[i][j]) + " ");
				}
				bw.newLine();
			}
			
			bw.flush();
			System.exit(0);
		}else {
			if(sdokoo_array[x][y] == 0) {
				boolean[] Visitable_array = {true, true, true, true, true, true, true, true, true};
				
				//가로에 있는 데이터 확인
				for(int i = 0; i < 9; i++) {
					if(sdokoo_array[x][i] != 0) {
						int index = sdokoo_array[x][i] - 1;
						Visitable_array[index] = false;
					}
				}
				
				//세로에 있는 데이터 확인
				for(int i = 0; i < 9; i++) {
					if(sdokoo_array[i][y] != 0) {
						int index = sdokoo_array[i][y] - 1;
						Visitable_array[index] = false;
					}
				}
				
				//3*3 사각형에 있는 데이터 확인
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
				
				//아무 숫자도 못 들어오면 이전상황으로 다시 돌아간다
				int false_count = 0;
				
				for(int i = 0; i < 9; i++) {
					if(!Visitable_array[i]) {
						false_count++;
					}
				}
				
				if(false_count < 9) {
					for(int i = 0; i < 9; i++) {
						if(Visitable_array[i]) {//들어올 수 있는 숫자는 들어온다
							sdokoo_array[x][y] = i + 1;
							
							if(y == 8) {
								x++;
								y = 0;
								search(x,y);
								
								//이 부분이 있어야 원래 있던 자리에 원상복구가 된다
								x--;
								y = 8;
								sdokoo_array[x][y] = 0;
							}else {
								y++;
								search(x,y);
								
								//이 부분이 있어야 원래 있던 자리에 원상복구가 된다
								y--;
								sdokoo_array[x][y] = 0;
							}
						}
					}
				}
				
			}else {//0이 아닌값이 들어왔을 때
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
