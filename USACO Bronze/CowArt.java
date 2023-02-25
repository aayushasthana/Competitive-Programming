import java.util.*;
import java.io.*;

public class CowArt {

	static char[][] adj;
	static int[][] vis;
	static int N;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("cowart.in"));
		PrintWriter w = new PrintWriter("cowart.out");
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//inputs
		int N = Integer.parseInt(st.nextToken());
		adj = new char[N+2][N+2];
		for (int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			String curr = st.nextToken();
			for (int j=1; j<N+1; j++) {
				adj[i][j] = curr.charAt(j-1);
			}
		}
		
		//human floodfill
		vis = new int[N+2][N+2];
		int h = 1;
		for (int i=1; i<N+1; i++) {
			for (int j=1; j<N+1; j++) {
				if (vis[i][j] == 0) {
					floodfill(i, j, h);
					h++;
				}
			}
		}
		
		//transition to red-green colorblind
		for (int i=0; i<N+2; i++) {
			for (int j=0; j<N+2; j++) {
				if (adj[i][j] == 'G') {
					adj[i][j] = 'R';
				}
			}
		}
		
		//cow floodfill
		vis = new int[N+2][N+2];
		int c = 1;
		for (int i=1; i<N+1; i++) {
			for (int j=1; j<N+1; j++) {
				if (vis[i][j] == 0) {
					floodfill(i, j, h);
					c++;
				}
			}
		}
		
		//answer is colors - 1
		w.println((h-1) + " " + (c-1));
		w.close();
	}
	
	public static void floodfill(int nodeRow, int nodeCol, int color) {
		if (vis[nodeRow][nodeCol] > 0) {
			return;
		}
		
		vis[nodeRow][nodeCol] = color;
		for (int i=0; i<4; i++) {
			if (adj[nodeRow+dy[i]][nodeCol+dx[i]] == adj[nodeRow][nodeCol] && vis[nodeRow+dy[i]][nodeCol+dx[i]] == 0) {
				floodfill(nodeRow+dy[i], nodeCol+dx[i], color);
			}
		}
	}
}
