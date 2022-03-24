import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No14889 {
	
	static int[][] stat;
	static boolean[] visit;
	static ArrayList<StringBuilder> team_list1 = new ArrayList<StringBuilder>();
	static ArrayList<StringBuilder> team_list2 = new ArrayList<StringBuilder>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		stat = new int[n][n];
		visit = new boolean[n];
		int[] member = new int[n / 2];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				stat[i][j] = in.nextInt();
			}//in - for
		}//out - for
		
		member[0] = 1;
		visit[0] = true;
		Divide_team(member, 1);
		
		ArrayList<Integer> synergy_list = new ArrayList<Integer>();
		
		for(int i = 0; i < team_list1.size(); i++) {
			StringBuilder team1 = team_list1.get(i);
			StringBuilder team2 = team_list2.get(i);
			
			int team1_synergy = Calculate_synergy(team1);
			int team2_synergy = Calculate_synergy(team2);
			
			synergy_list.add(Math.abs(team1_synergy - team2_synergy));
		}
		
		Collections.sort(synergy_list);
		System.out.println(synergy_list.get(0));
	}//main
	
	public static void Divide_team(int[] member, int index) {
		
		if(index == member.length) {
			StringBuilder team1 = new StringBuilder();
			StringBuilder team2 = new StringBuilder();
			
			for(int i = 0; i < visit.length; i++) {
				if(visit[i]) {
					team1.append(i + 1 + " ");
				}else {
					team2.append(i + 1 + " ");
				}
			}
			
			team_list1.add(team1);
			team_list2.add(team2);
			
		}else {
			for(int i = 0; i < visit.length; i++) {
				if(!visit[i]) {
					if(i + 1 > member[index - 1]) {
						member[index] = i + 1;
						visit[i] = true;
						index++;
						
						Divide_team(member, index);
						
						index--;
						visit[i] = false;
						member[index] = 0;
					}
				}
			}
		}
	}//Divide_team
	
	public static int Calculate_synergy(StringBuilder team) {
		int exp = 0;
		
		StringTokenizer st = new StringTokenizer(team.toString());
		int[] team_member = new int[st.countTokens()];
		
		int st_index = 0;
		while(st.hasMoreTokens()) {
			team_member[st_index] = Integer.parseInt(st.nextToken());
			st_index++;
		}
		
		for(int i = 0; i < team_member.length; i++) {
			int width = team_member[i] - 1;
			for(int j = 0; j < team_member.length; j++) {
				if(i != j) {
					int height = team_member[j] - 1;
					exp += stat[width][height];
				}
			}
		}
		
		return exp;
	}//Calculate_synergy
	
}
