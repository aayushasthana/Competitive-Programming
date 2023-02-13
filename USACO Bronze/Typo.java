import java.util.*;
import java.io.*;

public class Typo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("typo.in"));
		PrintWriter w = new PrintWriter("typo.out");
		
		String input = sc.next();
		sc.close();
		
		int N = input.length();
		int[] p = new int[N];
		int total = 0;
		
		for (int i=0; i<N; i++) {
			if (input.charAt(i) == '(') total++;
			else total--;
			p[i] = total;
		}

		long count = 0;
		if (p[N-1] == -2) {
			int lastNegative2 = 0;
			for (int i=0; i<N; i++) {
				if (p[i] == -2) {
					lastNegative2 = i;
					break;
				}
			}
			
			for (int i=0; i<lastNegative2; i++) {
				if (input.charAt(i) == ')' && i!=N-1) count++;
			}
		} else if (p[N-1] == 2) {
			int lastLessThan2 = 0;
			for (int i=N-1; i>=0; i--) {
				if (p[i] <= 1) {
					lastLessThan2 = i;
					break;
				}
			}
			
			for (int i=lastLessThan2+1; i<N; i++) {
				if (input.charAt(i) == '(' && i!=0) count++;
			}
		}
		
		w.println(count);
		
		w.close();
	}

}
