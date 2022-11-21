import java.util.*;
import java.io.*;

public class SocialDistancingI {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new File("socdist1.in"));
		PrintWriter w = new PrintWriter("socdist1.out");
		
		int N = sc.nextInt();
		String input = sc.next();
		int[] stalls = new int[N];
		int[] stalls2 = new int[N];
		
		for (int i=0; i<N; i++) {
			if (input.charAt(i) == '1') {
				stalls[i] = 1;
				stalls2[i] = 1;
			} else {
				stalls[i] = 0;
				stalls2[i] = 1;
			}
		}
		
		sc.close();
		
		//for (int i=0; i<N; i++) {
			//System.out.print(stalls[i] + " ");
		//}
		
		/*
		 Do this process twice:
			 int biggestGapLength = 0;
			 int biggestGapIndex = 0;
			 int currentGapLength = 0;
			 iterate through stalls:
		 		if (stalls[i] == 0):
		 			currentGapLength++;
		 		else:
		 			if (biggestGapLength < currentGapLength):
		 				biggestGapLength = currentGapLength;
		 				biggestGapIndex = i;
		 			currentGapLength = 0;
			 
			 if (biggestGapLength%2 == 0):
			 	stalls[biggestGapIndex-(biggestGapLength/2)] = 1;
			 else:
			 	stalls[biggestGapIndex- (biggestGapLength/2) + 1] = 1;
		 
		 int D = 0;
		 int currentGapLength = 0;
		 iterate through stalls:
	 		if (stalls[i] == 0):
	 			currentGapLength++;
	 		else:
	 			D = Math.min(D, currentGapLength);
	 			currentGapLength = 0;
	 	 
	 	 print(D+1);
		 */
		
		
		for (int a=0; a<2; a++) {
			int biggestGapLength = 0;
			int biggestGapIndex = 0;
			int currentGapLength = 0;
			int startGapLength = 0;
			int endGapLength = 0;
			int first1Index = 0;
			int last1Index = 0;
			
			for (int i=0; i<N; i++) {
				if (stalls[i] == 1) {
					first1Index = i;
					startGapLength = i;
					break;
				}
			}
			
			for (int i=N-1; i>=0; i--) {
				if (stalls[i] == 1) {
					endGapLength = N-i-1;
					last1Index = i;
					break;
				}
			}
			
			System.out.println("Start Gap Length: " + startGapLength);
			System.out.println("End Gap Length: " + endGapLength);
			
			for (int i=first1Index; i<=last1Index; i++) {
				if (stalls[i] == 0) {
					currentGapLength++;
				}
		 			
		 		else {
		 			if (biggestGapLength < currentGapLength) {
		 				biggestGapLength = currentGapLength;
		 				biggestGapIndex = i;
		 			}
		 			currentGapLength = 0;
		 		}		
			}
			
			System.out.println("Biggest Gap Length: " + biggestGapLength);
			
			if (endGapLength > startGapLength && biggestGapLength < endGapLength) {
				System.out.println("IN CONDITION 1");
				stalls[N-1] = 1;
			}
			
			else if (endGapLength < startGapLength && biggestGapLength < startGapLength) {
				System.out.println("IN CONDITION 2");
				stalls[0] = 1;
			}
			
			else if (endGapLength == startGapLength && biggestGapLength < startGapLength) {
				System.out.println("IN CONDITION 3");
				stalls[0] = 1;
			}
			
			else {
				System.out.println("IN ELSE");
				if (biggestGapLength%2 == 0) {
					stalls[biggestGapIndex-(biggestGapLength/2)] = 1;
				}
				 	
				else {
					stalls[biggestGapIndex - (biggestGapLength/2) - 1] = 1;
				}
			}
			
			
			for (int i=0; i<N; i++) {
				System.out.print(stalls[i] + " ");
			}
			System.out.println();
			System.out.println();
		}
		
		int D = 10000000;
		int currentGapLength = 0;
		
		int first1Index = 0;
		int last1Index = 0;
		
		for (int i=0; i<N; i++) {
			if (stalls[i] == 1) {
				first1Index = i;
				break;
			}
		}
		
		for (int i=N-1; i>=0; i--) {
			if (stalls[i] == 1) {
				last1Index = i;
				break;
			}
		}
		
		for (int i=first1Index; i<=last1Index; i++) {
			if (stalls[i] == 0) {
				currentGapLength++;
			}
			
			else {
				if (i != first1Index) {
					D = Math.min(D, currentGapLength);
					currentGapLength = 0;
				}
			}
		}
		
		D++;
		System.out.println("D's value: " + D);
		w.println(D);
		
		w.close();
	}

}
