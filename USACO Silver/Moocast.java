import java.util.*;
import java.io.*;

public class Moocast {
	
	static int[] nodeX;
	static int[] nodeY;
	static int[] nodeRadius;
	static boolean[] vis;
	static int curr;
	static int N;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter w = new PrintWriter("moocast.out");
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		nodeX = new int[N];
		nodeY = new int[N];
		nodeRadius = new int[N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			nodeX[i] = Integer.parseInt(st.nextToken());
			nodeY[i] = Integer.parseInt(st.nextToken());
			nodeRadius[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for (int i=0; i<N; i++) {
			vis = new boolean[N];
			curr = 0;
			dfs(i);
			max = Math.max(max, curr);
		}
		
		w.println(max);
		w.close();
	}

	public static void dfs(int node) {
		if (vis[node]) {
			return;
		}
		
		vis[node] = true;
		curr++;
		
		for (int i=0; i<N; i++) {
			if (inRange(node, i) && !vis[i]) {
				dfs(i);
			}
		}
	}
	
	public static boolean inRange(int start, int goal) {
		double xDistSq = Math.pow(Math.abs(nodeX[goal]-nodeX[start]), 2);
		double yDistSq = Math.pow(Math.abs(nodeY[goal]-nodeY[start]), 2);
		double nodeRadiusSq = Math.pow(nodeRadius[start], 2);
		return (xDistSq + yDistSq) <= nodeRadiusSq;
	}
}
