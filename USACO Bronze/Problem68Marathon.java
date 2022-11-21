import java.util.*;
import java.io.*;

public class Problem68Marathon {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("marathon.in"));
		PrintWriter w = new PrintWriter("marathon.out");
		
		int N = sc.nextInt();
		int[][] checkpoints = new int[N][2];
		
		/*
		 * calculate the total distance
		 */
		int totalDist = 0;
		int currX = sc.nextInt(); 
		int currY = sc.nextInt();
		
		for (int i=1; i<N; i++) {
			checkpoints[i][0] = sc.nextInt();
			checkpoints[i][1] = sc.nextInt();
			
			totalDist += Math.abs(currX - checkpoints[i][0]) + Math.abs(currY - checkpoints[i][1]);
			
			currX = checkpoints[i][0];
			currY = checkpoints[i][1];
		}
		
		sc.close();
		
		/*
		 * Iterate through points, and for each point, find how much the distance will be
		 * reduced if that point was skipped.
		 */
		int maxDistReduction = 0;
		for (int i=1; i<N-1; i++) {
			int calc1 = Math.abs(checkpoints[i][0] - checkpoints[i-1][0]) + Math.abs(checkpoints[i][1] - checkpoints[i-1][1]);
			int calc2 = Math.abs(checkpoints[i+1][0] - checkpoints[i][0]) + Math.abs(checkpoints[i+1][1] - checkpoints[i][1]);
			int ogDist = calc1 + calc2;
			int newDist = Math.abs(checkpoints[i+1][0] - checkpoints[i-1][0]) + Math.abs(checkpoints[i+1][1] - checkpoints[i-1][1]);
			
			int distReduction = ogDist - newDist;
			maxDistReduction = Math.max(distReduction, maxDistReduction);
		}
		
		w.println(totalDist - maxDistReduction);
		
		w.close();
	}

}
