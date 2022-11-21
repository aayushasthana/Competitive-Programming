import java.util.*;
import java.io.*;

public class LoadBalancing {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("balancing.in"));
		PrintWriter w = new PrintWriter("balancing.out");
		
		int N = sc.nextInt();
		sc.nextInt();
		
		int[] cowX = new int[N+1];
		int[] cowY = new int[N+1];
		
		cowX[0] = -1;
		cowY[0] = -1;
		
		for (int i=1; i<N+1; i++) {
			cowX[i] = sc.nextInt();
			cowY[i] = sc.nextInt();
		}
		
		sc.close();
		
		for (int i=1; i<N+1; i++) {
			System.out.println(cowX[i] + " " + cowY[i]);
		}
		
		/*
		 int M = 1000000;
		 iterate through cow x's:
		 	iterate through cow y's:
		 		int a = current x+1;
		 		int b = current y+1;
		 		
		 		int currentM = calculate M;
		 		M = Math.min(M, currentM);
		 */
		
		int M = 101;
		for (int i=1; i<N+1; i++) {
			for (int j=1; j<N+1; j++) {
				int a = cowX[i]+1;
				int b = cowY[j]+1;
				
				//System.out.println(a + " " + b);
				
				int currentM = 0;
				
				int p = 0;
				int q = 0;
				int r = 0;
				int s = 0;
				for (int k=1; k<N+1; k++) {
					//Find all values greater than a and greater than b
					if (cowX[k] > a && cowY[k] > b) {
						p++;
					}
					
					//Find all values greater than a and less than b
					if (cowX[k] > a && cowY[k] < b) {
						q++;
					}
					
					//Find all values less than a and less than b
					if (cowX[k] < a && cowY[k] < b) {
						r++;
					}
					
					//Find all values less than a and greater than b
					if (cowX[k] < a && cowY[k] > b) {
						s++;
					}
				}
				
				currentM = Math.max(s, Math.max(r, Math.max(p, q)));
				M = Math.min(M, currentM);
				//System.out.println(M);
			}
		}
		
		w.println(M);
		
		w.close();
	}
}
