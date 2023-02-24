import java.util.*;
import java.io.*;

public class ClosingTheFarm {
	
	static ArrayList<Integer>[] adj;
	static boolean[] vis;
	static boolean[] del;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("closing.in"));
		PrintWriter w = new PrintWriter("closing.out");
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N];
		for (int i=0; i<N; i++) adj[i] = new ArrayList<Integer>();
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			adj[start].add(end);
			adj[end].add(start);
		}
		
		del = new boolean[N];
		for (int i=0; i<N; i++) {
			vis = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				if (!del[j]) {
					floodfill(j);
					break;
				}
			}
			
			if (everyoneVisited()) {
				w.println("YES");
			} else {
				w.println("NO");
			}
			
			del[Integer.parseInt(st.nextToken())-1] = true;
		}

		w.close();
	}

	public static void floodfill (int node) {
		//base case
		if (vis[node] || del[node]) {
			return;
		}
		
		vis[node] = true;
		
		//transition
		for (int i=0; i<adj[node].size(); i++) {
			floodfill(adj[node].get(i));
		}
	}
	
	public static boolean everyoneVisited() {
		for (int i=0; i<N; i++) {
			if (!vis[i] && !del[i]) {
				return false;
			}
		}
		return true;
	}
}
