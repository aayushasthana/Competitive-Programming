import java.util.*;
import java.io.*;

public class BalancedTeams {

	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("bteams.in"));
		PrintWriter w = new PrintWriter("bteams.out");
		
		ArrayList<Integer> skill = new ArrayList<Integer>();
		for (int i=0; i<12; i++) skill.add(sc.nextInt());
		sc.close();
		
		generateTeams(skill, Integer.MAX_VALUE, Integer.MIN_VALUE);
		w.println(ans);
		w.close();
	}
	
	public static void generateTeams(ArrayList<Integer> left, int min, int max) {
		if (left.size() > 0) {
			for (int i=0; i<left.size(); i++) {
				for (int j=i+1; j<left.size(); j++) {
					for (int k=j+1; k<left.size(); k++) {
						int currMin = Math.min(left.get(i) + left.get(j) + left.get(k), min);
						int currMax = Math.max(left.get(i) + left.get(j) + left.get(k), max);
						
						ArrayList<Integer> next = new ArrayList<Integer>();
						for (int a=0; a<left.size(); a++) {
							if (a != i && a != k && a != j) {
								next.add(left.get(a));
							}
						}
						
						generateTeams(next, currMin, currMax);
					}
				}
			}
		}
		
		else ans = Math.min(ans, max-min);
	}
}
