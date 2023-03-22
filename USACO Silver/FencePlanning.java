import java.io.*;
import java.util.*;

public class FencePlanning {
	static ArrayList<Integer>[] adj;
	static long[] x;
	static long[] y;
	static boolean[] vis;
	static long maxX;
	static long minX;
	static long maxY;
	static long minY;
	
	public static void dfs(int node) {
		maxX = Math.max(x[node], maxX);
		minX = Math.min(x[node], minX);
		maxY = Math.max(y[node], maxY);
		minY = Math.min(y[node], minY);
		vis[node] = true;
		
		for (int i=0; i<adj[node].size(); i++) {
			if (!vis[adj[node].get(i)]) {
				dfs(adj[node].get(i));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
		PrintWriter w = new PrintWriter("fenceplan.out");
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		vis = new boolean[N];
		adj = new ArrayList[N];
		for (int i=0; i<N; i++) adj[i] = new ArrayList<Integer>();
		
		x = new long[N];
		y = new long[N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			adj[start].add(end);
			adj[end].add(start);
		}
		
		long minRect = Long.MAX_VALUE;
		for (int i=0; i<N; i++) {
			maxX = Long.MIN_VALUE;
			minX = Long.MAX_VALUE;
			maxY = Long.MIN_VALUE;
			minY = Long.MAX_VALUE;
			
			if (!vis[i]) {
				dfs(i);
				minRect = Math.min(minRect, 2*((maxX-minX)+(maxY-minY)));
			}
		}
		
		w.println(minRect);
		w.close();
	}

}
