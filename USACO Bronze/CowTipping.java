import java.util.*;
import java.io.*;

public class CowTipping {
	static int N;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("cowtip.in"));
		PrintWriter w = new PrintWriter("cowtip.out");
		
		N = sc.nextInt();
		int[][] grid = new int[N][N];
		
		for (int i=0; i<N; i++) {
			String input = sc.next();
			for (int j=0; j<N; j++) {
				if (input.charAt(j) == '1') {
					grid[i][j] = 1;
				} else {
					grid[i][j] = 0;
				}
			}
		}
		
		sc.close();
		
		/*
		 find furthest one
		 flip
		 check done
		 repeat until done
		 */
		
		boolean done = false;
		int count = 0;
		int x = 0;
		int y = 0;
		
		while (done == false) {
			if (checkDone(grid)) {
				done = true;
			} else {
				x = find1(grid)[0];
				y = find1(grid)[1];
				
				grid = flip(grid, x, y);
				count++;
			}
		}
		
		w.println(count);
		
		w.close();
	}
	
	public static int[] find1(int[][] board) {
		int maxDistance = 0;
		int[] retval = new int[2];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (board[i][j] == 1 && i+j > maxDistance) {
					maxDistance = i+j;
					retval[0] = i;
					retval[1] = j;
				}
			}
		}
		
		return retval;
	}
	
	public static int[][] flip(int[][] board, int rows, int cols) {
		int[][] retval = board;
		
		for (int i=0; i<=rows; i++) {
			for (int j=0; j<=cols; j++) {
				if (retval[i][j] == 1) {
					retval[i][j] = 0;
				} else {
					retval[i][j] = 1;
				}
			}
		}
		
		return retval;
	}
	
	public static boolean checkDone(int[][] board) {
		boolean retval = true;
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (board[i][j] == 1) {
					retval = false;
				}
			}
		}
		
		return retval;
	}
}
