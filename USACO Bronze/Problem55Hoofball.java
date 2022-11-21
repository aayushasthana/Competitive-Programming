import java.util.*;
import java.io.*;

public class Problem55Hoofball {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("hoofball.in"));
		PrintWriter w = new PrintWriter("hoofball.out");
		
		int N = sc.nextInt();
		int[] cows = new int[N+1];
		for (int i=1; i<N+1; i++) {
			cows[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(cows);
		
		/*
		sort array
		iterate through array finding which cows pass left and right
		-> 1 = right, -1 = left
		 */
		
		int[] cowPasses = new int[N+1];
		cowPasses[1] = 1;
		cowPasses[N] = -1;
		
		for (int i=2; i<=N-1; i++) {
			int distLeft = cows[i] - cows[i-1];
			int distRight = cows[i+1] - cows[i];
			
			if (distLeft < distRight) {
				cowPasses[i] = -1;
			} else if (distRight < distLeft) {
				cowPasses[i] = 1;
			} else {
				cowPasses[i] = -1;
			}
		}
		
		int count = 1;
		
		int pointer = 1;
		int sectionLength = 0;
		ArrayList<Integer> len1Indecies = new ArrayList<Integer>();
		
		for (int i=1; i<N+1; i++) {
			if (cowPasses[i] != pointer && pointer == 1) {
				pointer = -1;
				count++;
				if (sectionLength == 1) {
					len1Indecies.add(i-1);
				}
				sectionLength = 1;
			}
			
			else if (cowPasses[i] != pointer && pointer == -1) {
				pointer = 1;
				count++;
				if (sectionLength == 1) {
					len1Indecies.add(i-1);
				}
				sectionLength = 1;
			} 
			
			else {
				sectionLength++;
			}
		}
		
		if (len1Indecies.size() > 0 && cowPasses[N] != cowPasses[N-1]) {
			len1Indecies.add(N);
		}
			
		System.out.println(len1Indecies);
		
		for (int i=0; i<len1Indecies.size(); i++) {
			if (cowPasses[len1Indecies.get(i)-1] == 1 || cowPasses[len1Indecies.get(i)+1] == -1){
				count--;
			}
		}
		
		for (int i=0; i<len1Indecies.size()-1; i++) {
			if ((len1Indecies.get(i+1) - len1Indecies.get(i)) == 1 && cowPasses[len1Indecies.get(i)] == 1 && cowPasses[len1Indecies.get(i+1)] == -1) {
				System.out.println("Count Increased");
				count++;
			}
		}
		
		w.println(count);
		w.close();
	}

}