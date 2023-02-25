import java.util.*;
import java.io.*;

public class ComfortableCows {

	static int count = 0;
	static int[][] grid = new int[4000][4000]; //(0,0) is grid[2000][2000], 0 = no cow, 1 = input cow, 2 = added cow
	static int[] dx = {0,0,0,1,-1};
	static int[] dy = {0,1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter w = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) + 2000;
			int y = Integer.parseInt(st.nextToken()) + 2000;
			
			if (grid[x][y] == 0)
				grid[x][y] = 1;
			else if (grid[x][y] == 2) {
				grid[x][y] = 1;
				count--;
			}
			
			adjustIfNeeded(x, y);
			w.println(count);
		}
		
		w.close();
	}

	//find which cows to make uncomfortable
	public static void adjustIfNeeded(int x, int y) {
		for (int i=0; i<5; i++) {
			if (checkComfy(x+dx[i], y+dy[i]) && grid[x+dx[i]][y+dy[i]] > 0) {
				makeUncomfy(x+dx[i], y+dy[i]);
			}
		}
	}
	
	//make current cow uncomfy and start other adjustments
	public static void makeUncomfy(int x, int y) {
		for (int i=1; i<5; i++) {
			if (grid[x+dx[i]][y+dy[i]] == 0) {
				grid[x+dx[i]][y+dy[i]] = 2;
				count++;
				adjustIfNeeded(x+dx[i], y+dy[i]);
			}
		}
	}
	
	//check if a given cow is uncomfortable
	public static boolean checkComfy(int x, int y) {
		int cows = 0;
		for (int i=1; i<5; i++) {
			if (grid[x+dx[i]][y+dy[i]] > 0)
				cows++;
		}
		return (cows == 3);
	}
}
