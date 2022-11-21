import java.util.*;
import java.io.*;

public class Problem37TamingTheHerd {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("taming.in"));
		PrintWriter w = new PrintWriter("taming.out");
		
		int N = sc.nextInt();
		int[] breakouts = new int[N+1];
		breakouts[0] = -2;
		
		for (int i=1; i<N+1; i++) {
			breakouts[i] = sc.nextInt();
		}
		
		sc.close();
		
		/*
		 char[] count = new char[N+1]
		 count array KEY:
		 	N = no breakout
		 	D = definite breakout (add to both max and min)
		 	U = unsure breakout (add to only max)
		 
		 count[1] = 'D';
		 iterate through breakouts array backwards:
		 	if (current element) == 0:
		 		count[i] = 'D';
		 	else if (current element) == -1:
		 		if (count[i] == 'D'):
		 			continue;
		 		else:
		 			count[i] = 'U';
		 	else (current element is a positive number):
		 		count[i] = 'N';
		 		if (i-current element < 2):
		 			continue;
		 		else:
		 			count[i-current element] == 'D';
		 */
		
		char[] count = new char[N+1];
		count[1] = 'D';
		boolean valid = true;
		
		if (breakouts[1] > 0) {
			valid = false;
		}
		
		for (int i=N; i>1; i--) {
			if (breakouts[i] == 0) {
				count[i] = 'D';
			}
			
			else if (breakouts[i] == -1) {
				if (count[i] == 'D' || count[i] == 'N') {
					continue;
				}
		 		
				else {
		 			count[i] = 'U';
		 		}	
			}
			
			else {
				if (i-breakouts[i] < 1) {
					valid = false;
					break;
				}
				
				else if (breakouts[i-breakouts[i]] > 0) {
					valid = false;
					break;
				}
				
				else {
					count[i-breakouts[i]] = 'D';
					for (int j=i; j>i-breakouts[i]; j--) {
						count[j] = 'N';
					}
				}
			}
		}
		
		if (!valid) {
			w.println(-1);
			w.close();
			System.exit(0);
		}
		
		int min = 0;
		int max = 0;
		for (int i=1; i<N+1; i++) {
			if (count[i] == 'D') {
				min++;
				max++;
			}
			
			else if (count[i] == 'U') {
				max++;
			}
		}
		
		w.println(min + " " + max);
		w.close();
	}

}
