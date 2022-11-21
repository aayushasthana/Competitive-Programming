import java.util.*;
import java.io.*;

public class Problem42MilkMeasurement {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("measurement.in"));
		PrintWriter w = new PrintWriter("measurement.out");
		
		int N = sc.nextInt();
		int[] milkCount = new int[3];
		//0 = Bessie, 1 = Elsie, 2 = Mildred
		
		HashMap<Integer, Integer> whichCow = new HashMap<Integer, Integer>();
		//Maps time to which cow is being affected (0 = Bessie, 1 = Elsie, 2 = Mildred)
		
		int[] milkChanges = new int[101];
		milkChanges[0] = -1;
		//Milk changes at each time
		
		for (int i=0; i<N; i++) {
			int time = sc.nextInt();
			String cow = sc.next();
			int change = sc.nextInt();
			
			milkChanges[time] = change;
			
			if (cow.equals("Bessie")) {
				whichCow.put(time, 0);
			} else if (cow.equals("Elsie")) {
				whichCow.put(time, 1);
			} else if (cow.equals("Mildred")) {
				whichCow.put(time, 2);
			}
		}
		
		sc.close();
		
		/*
		 int count = 0;
		 int[] currentFrame = {0, 0, 0};
		 Iterate through milkChanges array:
		 	if (current element > 0):
		 		update milk count
		 		if (currentFrame changes):
		 			count++;
		 */
		
		
		int count = 0;
		int[] currentFrame = {0, 0, 0};
		
		for (int time=0; time<101; time++) {
			if (whichCow.containsKey(time)) {
				
				milkCount[whichCow.get(time)] += milkChanges[time];
				
				
				int[] prevFrame = Arrays.copyOf(currentFrame, 3);
				
				//0 greatest
				if (milkCount[0] > milkCount[1] && milkCount[0] > milkCount[2]) {
					currentFrame[0] = 1;
					currentFrame[1] = 0;
					currentFrame[2] = 0;
				}
				
				//1 greatest
				else if (milkCount[1] > milkCount[0] && milkCount[1] > milkCount[2]) {
					currentFrame[0] = 0;
					currentFrame[1] = 1;
					currentFrame[2] = 0;
				}
				
				//2 greatest
				else if (milkCount[2] > milkCount[0] && milkCount[2] > milkCount[1]) {
					currentFrame[0] = 0;
					currentFrame[1] = 0;
					currentFrame[2] = 1;
				}
				
				//0 and 1 tied
				else if (milkCount[0] > milkCount[2] && milkCount[0] == milkCount[1]) {
					currentFrame[0] = 1;
					currentFrame[1] = 1;
					currentFrame[2] = 0;
				}
				
				//0 and 2 tied
				else if (milkCount[0] > milkCount[1] && milkCount[0] == milkCount[2]) {
					currentFrame[0] = 1;
					currentFrame[1] = 0;
					currentFrame[2] = 1;
				}
				
				//1 and 2 tied
				else if (milkCount[1] > milkCount[0] && milkCount[1] == milkCount[2]) {
					currentFrame[0] = 0;
					currentFrame[1] = 1;
					currentFrame[2] = 1;
				}
				
				//All are tied
				else if (milkCount[0] == milkCount[1] && milkCount[1] == milkCount[2]) {
					currentFrame[0] = 1;
					currentFrame[1] = 1;
					currentFrame[2] = 1;
				}
				
				boolean incCount = false;
				
				for (int i=0; i<3; i++) {
					if (currentFrame[i] != prevFrame[i]) {
						incCount = true;
					}
				}
				
				if (incCount) {
					count++;
				}
				
			}
			
			System.out.print("Day "+time+" Frame: ");
			for (int i=0; i<3; i++) {
				System.out.print(currentFrame[i]+" ");
				
			}
			System.out.print("Current Counts: ");
			for (int i=0; i<3; i++) {
				System.out.print(milkCount[i] + " ");
			}
			
			System.out.println();
			
		}
		
		w.println(count);
		
		w.close();
	}
}
