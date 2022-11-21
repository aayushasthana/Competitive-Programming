import java.util.*;
import java.io.*;

public class Problem47OutOfPlace {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("outofplace.in"));
		PrintWriter w = new PrintWriter("outofplace.out");
		
		int N = sc.nextInt();
		int[] givenOrder = new int[N];
		int[] desiredOrder = new int[N];
		
		for (int i=0; i<N; i++) {
			givenOrder[i] = sc.nextInt();
			desiredOrder[i] = givenOrder[i];
		}
		
		sc.close();
		
		
		
		Arrays.sort(desiredOrder);
		
		/*
		 sorted = false;
		 count = 0;
		 while not sorted and i=0...N-1:
		 	swapper1 = givenOrder[i]
		 	if (toBeMoved == desiredOrder[i]):
		 		continue;
		 	
		 	for j=0...N-1 && j != i:
		 		swapper2 = givenOrder[j]
		 		//If swapper2 is already in a good position
		 		if (swapper2 == desiredOrder[j]):
		 			if sorted:
		 				sorted = true;
		 			continue
		 		
		 		//If swapper1 and swapper2 are equal
		 		else if (swapper1 == swapper2):
		 			if sorted:
		 				sorted = true;
		 			continue
		 		
		 		//If swapping puts either in a good position
		 		else if (swapper1 == desiredOrder[j] or swapper2 == desiredOrder[i]):
		 			swap 1 and 2
		 			count++
		 			
		 			if sorted:
		 				sorted = true;
		 			
		 			break;
		 	
		 	if (i==N-1):
		 		i=0;
		 	else:
		 		i++;
		 */
		
		boolean sorted = false;
		int count = 0;
		int i=0;
		
		while (sorted == false) {
			System.out.println("IN WHILE");
			int swapper1 = givenOrder[i];
			if (swapper1 == desiredOrder[i]) {
				i++;
				continue;
			}
			
			for (int j=0; j<N; j++) {
				System.out.println("IN J FOR");
				int swapper2 = givenOrder[j];
				if (swapper2 == desiredOrder[j] || swapper1 == swapper2) {
					System.out.println("IN IF");
					if (checkSorted(givenOrder, desiredOrder)) {
						sorted = true;
						break;
					}
					
					continue;
				}
		 		
				else if (swapper1 == desiredOrder[j] || swapper2 == desiredOrder[i]) {
					System.out.println("IN ELSE");
					givenOrder[j] = swapper1;
					givenOrder[i] = swapper2;
					count++;
					
					if (checkSorted(givenOrder, desiredOrder)) {
						sorted = true;
					}
					
					break;
				}
			}
			
			if (i==N-1) {
				i=0;
			}
		 	
			else {
		 		i++;
		 	}
		 		
		}
		
		w.println(count);
		
		w.close();
	}
	
	public static boolean checkSorted(int[] a, int[] b) {
		boolean isSorted = true;
		for (int k=0; k<a.length; k++) {
			if (a[k] != b[k]) {
				isSorted = false;
			}
		}
		
		return isSorted;
	}
}
