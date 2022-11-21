import java.util.*;
import java.io.*;

public class Problem54SwapitySwap {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("swap.in"));
		PrintWriter w = new PrintWriter("swap.out");
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] step1 = {sc.nextInt(), sc.nextInt()};
		int[] step2 = {sc.nextInt(), sc.nextInt()};
		
		int[] initial = new int[N+1];
		int[] cows = new int[N+1];
		
		for (int i=1; i<N+1; i++) {
			initial[i] = i;
			cows[i] = i;
		}
		
		sc.close();
		
		int stepsUntilEqual = 0;
		boolean equal = false;
		
		while (!equal) {
			cows = performSteps(cows, step1, step2);
			stepsUntilEqual++;
			
			equal = true;
			for (int i=0; i<N+1; i++) {
				if (cows[i] != initial[i]) {
					equal = false;
				}
			}
		}
		
		int neededSteps = K%stepsUntilEqual;
		for (int i=0; i<neededSteps; i++) {
			cows = performSteps(cows, step1, step2);
		}
		
		for (int i=1; i<N+1; i++) {
			w.println(cows[i]);
		}
		
		w.close();
	}
	
	public static int[] performSteps(int[] order, int[] first, int[] second) {
		int[] retval = order;
		
		//Step 1
		int[] reversal1 = new int[first[1] - first[0] + 1];
		int j=0;
		for (int i=first[1]; i>=first[0]; i--) {
			reversal1[j] = retval[i];
			j++;
		}
		
		j=0;
		for (int i=first[0]; i<=first[1]; i++) {
			retval[i] = reversal1[j];
			j++;
		}

		//Step 2
		int[] reversal2 = new int[second[1] - second[0] + 1];
		j=0;
		for (int i=second[1]; i>=second[0]; i--) {
			reversal2[j] = retval[i];
			j++;
		}
		
		j=0;
		for (int i=second[0]; i<=second[1]; i++) {
			retval[i] = reversal2[j];
			j++;
		}
		
		return retval;
	}
	
	public static void printArray(int[] input) {
		for (int i=0; i<input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
	}
}
