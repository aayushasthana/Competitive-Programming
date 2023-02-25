import java.util.*;
import java.io.*;

public class MooTube {

	static int ans;
	static int K;
	static int N;
	static ArrayList<Integer>[] adj;
	static ArrayList<Integer>[] weights;
	static boolean[] vis;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		PrintWriter w = new PrintWriter("mootube.out");
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N];
		weights = new ArrayList[N];
		for (int i=0; i<N; i++) adj[i] = new ArrayList<Integer>();
		for (int i=0; i<N; i++) weights[i] = new ArrayList<Integer>();
		
		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			adj[start].add(end);
			adj[end].add(start);
			weights[start].add(weight);
			weights[end].add(weight);
		}
		
		for (int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken())-1;
			
			vis = new boolean[N];
			ans = 0;
			dfs(V, Integer.MAX_VALUE);
			w.println(ans);
		}
		
		w.close();
	}
	
	public static void dfs(int node, int prevRelevance) {
		if (vis[node]) {
			return;
		}
		
		vis[node] = true;
		
		for (int i=0; i<adj[node].size(); i++) {
			if (!vis[adj[node].get(i)]) {
				int currRelevance = Math.min(prevRelevance, weights[node].get(i));
				if (currRelevance >= K) {
					ans++;
				}
				dfs(adj[node].get(i), currRelevance);
			}
		}
	}
}
