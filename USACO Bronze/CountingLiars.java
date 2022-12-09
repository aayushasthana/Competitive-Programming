import java.util.*;
import java.io.*;

public class CountingLiars {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] cows = new int[N][2];
		int[] positions = new int[N];
		
		for (int i=0; i<N; i++) {
			if (sc.next().equals("G")) {
				cows[i][0] = 1;
			} else {
				cows[i][0] = 0;
			}
			
			cows[i][1] = sc.nextInt();
			positions[i] = cows[i][1];
		}
		
		Arrays.sort(positions);
		
		sc.close();
		
		/*
		 sort positions
		 Iterate through positions:
		 	assume a position of bessie between positions
		 	iterate through cows
		 		count liars
		 */
		
		int min = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			int bessie = positions[i];
			int count = 0;
			
			for (int j=0; j<N; j++) {
				if (cows[j][0] == 1 && bessie >= cows[j][1]) {
					continue;
				}
				
				
				else if (cows[j][0] == 0 && bessie <= cows[j][1]) {
					continue;
				}
				
				else {
					count++;
				}
			}
			
			min = Math.min(count, min);
		}
		
		System.out.println(min);
	}

}