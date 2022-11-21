import java.util.*;
import java.io.*;

public class CircularBarn {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("cbarn.in"));
		PrintWriter w = new PrintWriter("cbarn.out");
		
		int N = sc.nextInt();
		int[] rooms = new int[N+1];
		rooms[0] = -1;
		
		for (int i=1; i<N+1; i++) {
			rooms[i] = sc.nextInt();
		}
		
		sc.close();
		
		ArrayList<Integer> possible = new ArrayList<Integer>();
		int distanceFromStart = 0;
		
		for (int i=1; i<N+1; i++) {
			int totalDistanceTraveled = 0;
			for (int j=1; j<N+1; j++) {
				if (i==j) {
					continue;
				}
				
				else if (j<i) {
					distanceFromStart = N - (i-j);
					totalDistanceTraveled += rooms[j] * distanceFromStart;
				}
				
				else {
					distanceFromStart = j-i;
					totalDistanceTraveled += rooms[j] * distanceFromStart;
				}
			}
			possible.add(totalDistanceTraveled);
		}
		
		w.println(Collections.min(possible));
		
		w.close();
	}

}
