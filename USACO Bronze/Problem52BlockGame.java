import java.util.*;
import java.io.*;

public class Problem52BlockGame {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("blocks.in"));
		PrintWriter w = new PrintWriter("blocks.out");
		
		int N = sc.nextInt();
		String[] side1 = new String[N];
		String[] side2 = new String[N];
		
		for (int i=0; i<N; i++) {
			side1[i] = sc.next();
			side2[i] = sc.next();
		}
		
		sc.close();
		
		int[] count = new int[27];
		
		for (char i='a'; i<='z'; i++) {
			count[i-96] += countChar(side1, side2, N, i);
		}
		
		for (int i=1; i<27; i++) {
			w.println(count[i]);
		}
		
		w.close();
	}
	
	public static int countChar(String[] blocks, String[] blocks2, int myN, char c) {
		int retval = 0;
		
		for (int i=0; i<myN; i++) {
			String curr1 = blocks[i];
			String curr2 = blocks2[i];
			
			int count1 = 0;
			int count2 = 0;
			
			for (int j=0; j<curr1.length(); j++) {
				if (curr1.charAt(j) == c) {
					count1++;
				}	
			}
			
			for (int j=0; j<curr2.length(); j++) {
				if (curr2.charAt(j) == c) {
					count2++;
				}
			}
			
			retval += Math.max(count1, count2);
		}
		
		return retval;
	}

}