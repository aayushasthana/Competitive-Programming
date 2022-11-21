import java.io.*;
import java.util.*;

public class Problem51ModernArtV3 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("art.in"));
		PrintWriter w = new PrintWriter("art.out");
		
		int N = sc.nextInt();
		int[][] picture = new int[N][N];
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for (int i=0; i<N; i++) {
			String input = sc.next();
			for (int j=0; j<N; j++) {
				picture[i][j] = (int) (input.charAt(j)) - 48;
				if (inArray(picture[i][j], nums) == false && picture[i][j] != 0) {
					nums.add(picture[i][j]);
				}
			}
		}
		
		HashSet<Integer> blocksAnother = new HashSet<Integer>();
		
		sc.close();
		
		for (int i=0; i<nums.size(); i++) {
			ArrayList<Integer> retval = checkIntercepted(nums.get(i),N,picture);
			for (int j=0; j<retval.size(); j++) {
				blocksAnother.add(retval.get(j));
			}
		}
		
		int count = 0;
		
		for (int i=0; i<nums.size(); i++) {
			if (blocksAnother.contains(nums.get(i)) == false) {
				count++;
			}
		}
		
		w.println(count);
		
		w.close();
	}
	
	public static ArrayList<Integer> checkIntercepted(int color, int myN, int[][] grid) {
		ArrayList<Integer> retval = new ArrayList<Integer>();
		
		boolean inArray = false;
		for (int i=0; i<myN; i++) {
			for (int j=0; j<myN; j++) {
				if (grid[i][j] == color) {
					inArray = true;
				}
			}
		}
		
		if (inArray) {
			int furthestRow = 0;
			int furthestCol = 0;
			int closestRow = 1000;
			int closestCol = 1000;
			
			for (int i=0; i<myN; i++) {
				for (int j=0; j<myN; j++) {
					if (grid[i][j] == color) {
						furthestRow = Math.max(furthestRow, i);
						furthestCol = Math.max(furthestCol, j);
						closestRow = Math.min(closestRow, i);
						closestCol = Math.min(closestCol, j);
					} 
				}
			}
			
			for (int i=closestRow; i<=furthestRow; i++) {
				for (int j=closestCol; j<=furthestCol; j++) {
					if (grid[i][j] != color) {
						if (inArray(grid[i][j], retval) == false) {
							retval.add(grid[i][j]);
						}
					}
				}
			}
			
			return retval;
		} 
		
		else {
			return retval;
		}
	}
	
	public static boolean inArray(int num, ArrayList<Integer> input) {
		boolean retval = false;
		
		for (int i=0; i<input.size(); i++) {
			if (num == input.get(i)) {
				retval = true;
			}
		}
		
		return retval;
	}
}
