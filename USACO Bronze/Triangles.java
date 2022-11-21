import java.util.*;
import java.io.*;

public class Triangles {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("triangles.in"));
		PrintWriter w = new PrintWriter("triangles.out");
		
		int N = sc.nextInt();
		int[] x = new int[N];
		int[] y = new int[N];
		
		for (int i=0; i<N; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		sc.close();
		
		/*
		 int M = 0;
		 1: iterate through points:
		 	
		 	2: iterate through points:
		 		find a point with the same X value
		 		find a point with the same Y value
		 		calculate M
		 		M = Math.max(currentM, M);
		 */
		
		for (int i=0; i<N; i++) {
			System.out.println(x[i] + " " + y[i]);
		}
		
		int M = 0;
		for (int i=0; i<N; i++) {
			int mainX = x[i];
			int mainY = y[i];
			
			int maxDistX = 0;
			int maxDistY = 0;
			
			for (int j=0; j<N; j++) {
				if (x[j] == mainX) {
					maxDistY = Math.max(maxDistY, Math.abs(y[j]-mainY));
				}
				
				if (y[j] == mainY) {
					maxDistX = Math.max(maxDistX, Math.abs(x[j]-mainX));
				}
			}
			
			M = Math.max(M, maxDistY*maxDistX);
		}
		
		w.println(M);
		
		w.close();
	}

}
