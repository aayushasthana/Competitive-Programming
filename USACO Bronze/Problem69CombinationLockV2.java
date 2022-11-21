import java.util.*;
import java.io.*;

public class Problem69CombinationLockV2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("combo.in"));
		PrintWriter w = new PrintWriter("combo.out");
		
		int N = sc.nextInt();
		int[] fj = new int[3];
		for (int i=0; i<3; i++) {
			fj[i] = sc.nextInt();
		}
		
		int[] ml = new int[3];
		for (int i=0; i<3; i++) {
			ml[i] = sc.nextInt();
		}
		
		sc.close();
		
		int[][] fjPossible = new int[3][5];
		int[][] mlPossible = new int[3][5];
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<5; j++) {
				fjPossible[i][j] = (N+(fj[i]-2+j))%N;
				mlPossible[i][j] = (N+(ml[i]-2+j))%N;
			}
		}
		
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<5; j++) {
				System.out.print(fjPossible[i][j] + " ");
			}
			System.out.println();
		}
		
		
		HashSet<ArrayList<Integer>> codes = new HashSet<ArrayList<Integer>>();		
		
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				for (int k=0; k<5; k++) {
					ArrayList<Integer> curr = new ArrayList<Integer>();
					curr.add(fjPossible[0][i]);
					curr.add(fjPossible[1][j]);
					curr.add(fjPossible[2][k]);
					
					//System.out.println(curr);
					codes.add(curr);
				}
			}
		}
		
		
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				for (int k=0; k<5; k++) {
					ArrayList<Integer> curr = new ArrayList<Integer>();
					curr.add(mlPossible[0][i]);
					curr.add(mlPossible[1][j]);
					curr.add(mlPossible[2][k]);
					
					//System.out.println(curr);
					codes.add(curr);
				}
			}
		}
		
		System.out.println(codes);
		w.println(codes.size());
		w.close();
	}

}
