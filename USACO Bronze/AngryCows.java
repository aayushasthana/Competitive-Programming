import java.util.*;
import java.io.*;

public class AngryCows {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new File("angry.in"));
		PrintWriter w = new PrintWriter("angry.out");
		
		int N = sc.nextInt();
		long[] points = new long[N];
		
		for (int i=0; i<N; i++) {
			points[i] = sc.nextLong();
		}
		
		sc.close();
		
		/*
		 iterate through points:
		 	simulate forward reaction
		 	simulate backward reaction
		 	
		 return max
		 */
		
		Arrays.sort(points);
		for (int i=0; i<N; i++) {
			System.out.print(points[i] + " ");
		}
		System.out.println();
		System.out.println();
		
		int max = 0;
		
		for (int i=0; i<N; i++) {
			System.out.println("Point Chosen: " + points[i]);
			
			int[] countArray = new int[N];
			int count = 0;
			int start = i;
			countArray[i] = 1;
			
			//Backwards reaction
			int j=0;
			int distance = 1;
			
			while (j<start) {
				
				
				if (points[start]-points[j] <= distance) {
					System.out.println("Backward Reaction Blows Up: " + points[j]);
					distance++;
					
					for (int k=j; k<=start; k++) {
						countArray[k] = 1;
					}
					
					start = j;
					j=0;
				}
				
				else {
					j++;
				}
			}
			
			//Forwards reaction
			j=N-1;
			distance = 1;
			start = i;
			while (j>start) {
				
				//Find furthest point blown up
				if (points[j]-points[start] <= distance) {
					System.out.println("Forward Reaction Blows Up: " + points[j]);
					distance++;
					
					for (int k=j; k>=start; k--) {
						countArray[k] = 1;
					}
					
					start = j;
					j=N-1;
				}
				
				else {
					j--;
				}
			}
			
			
			for (int a=0; a<N; a++) {
				System.out.print(countArray[a] + " ");
				if (countArray[a] == 1) {
					count++;
				}
			}
			
			System.out.println("Total Blown: " + count);
			System.out.println();
			
			
			max = Math.max(count, max); 
		}
		
		w.println(max);
		
		w.close();
	}

}
