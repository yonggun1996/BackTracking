import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No14888Buffer {
	
	static HashSet<String> operator_order_set = new HashSet<String>();
	static int[] operator_array = new int[4];
	static int[] visit_count = new int[4];
	static int[] number_array;

	public static void main(String[] args) throws IOException {
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int number_array_size = Integer.parseInt(st.nextToken());
		number_array = new int[number_array_size];
		
		for(int i = 0; i < number_array_size; i++) {
			st = new StringTokenizer(br.readLine());
			number_array[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			operator_array[i] = Integer.parseInt(st.nextToken());
			visit_count[i] = operator_array[i];
		}
		
		//연산 순서들을 담는 for문
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < operator_array[i]; j++) {
				StringBuilder operator_order = new StringBuilder();
				
				operator_order = append_operator_order(operator_order, i);
				
				visit_count[i]--;
				make_operator_order(operator_order, 0);
				visit_count[i]++;
				
			}//inner - for
		}//outer - for
		
		ArrayList<String> operator_order_list = new ArrayList<String>(operator_order_set);
		ArrayList<Long> calculation_result = new ArrayList<Long>();
		
		for(int i = 0; i < operator_order_list.size(); i++) {
			long result = Finding_Value(operator_order_list.get(i));
			calculation_result.add(result);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		if(calculation_result.size() == 1) {
			//System.out.println(calculation_result.get(0));
			//System.out.println(calculation_result.get(0));
			bw.write(String.valueOf(calculation_result.get(0)));
			bw.newLine();
			bw.write(String.valueOf(calculation_result.get(0)));
		}else {
			Collections.sort(calculation_result);
			//System.out.println(calculation_result.get(calculation_result.size() - 1));
			//System.out.println(calculation_result.get(0));
			bw.write(String.valueOf(calculation_result.get(calculation_result.size() - 1)));
			bw.newLine();
			bw.write(String.valueOf(calculation_result.get(0)));
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void make_operator_order(StringBuilder operator_order, int index) {
		
		if(operator_order.length() == number_array.length - 1) {
			operator_order_set.add(operator_order.toString());
		}else {
			
			for(int i = 0; i < 4; i++) {
				if(visit_count[i] != 0) {
					visit_count[i]--;
					operator_order = append_operator_order(operator_order, i);
					index++;
					
					make_operator_order(operator_order, index);
					
					visit_count[i]++;
					operator_order.deleteCharAt(index);
					index--;
				}
			}
		}
	}
	
	public static StringBuilder append_operator_order(StringBuilder operator_order, int flag) {
		switch (flag) {
		case 0:
			operator_order.append('+');
			break;

		case 1:
			operator_order.append('-');
			break;
			
		case 2:
			operator_order.append('*');
			break;
			
		case 3:
			operator_order.append('/');
			break;
		}//switch - case
		
		return operator_order;
	}
	
	public static long Finding_Value(String operator_order) {
		long result = number_array[0];
		
		for(int i = 0; i < operator_order.length(); i++) {
			
			if(result < 0) {
				Math.abs(result);
			}
			
			switch (operator_order.charAt(i)) {
			case '+':
				result += number_array[i + 1];
				break;

			case '-':
				result -= number_array[i + 1];
				break;
				
			case '*':
				result *= number_array[i + 1];
				break;
				
			case '/':
				result /= number_array[i + 1];
				break;
			}
			
		}
		
		return result;
		
	}

}
