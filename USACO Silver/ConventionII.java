import java.util.*;
import java.io.*;

public class ConventionII {
	
	static class Cow implements Comparable<Cow> {
		public int start;
		public int wait;
		public int snr;
		
		public Cow(int s, int w, int seniority) {
			start = s;
			wait = w;
			snr = seniority;
		}
		
		public int compareTo(Cow other) {
			return start - other.start;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
		PrintWriter w = new PrintWriter("convention2.out");
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		Cow[] cows = new Cow[N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			cows[i] = new Cow(start, time, i);
		}
		Arrays.sort(cows);
		
		PriorityQueue<Cow> q = new PriorityQueue<Cow>(new Comparator<Cow>() {
			public int compare(Cow a, Cow b) {
				return a.snr-b.snr;
			}
		});
		
		long time = 0;
		long ans = 0;
		int cowIndex = 0;
		
		while (cowIndex < N || q.size() > 0) {
			if (cowIndex < N && cows[cowIndex].start <= time) {
				q.add(cows[cowIndex]);
				cowIndex++;
			}
			
			else if (q.size() == 0) {
				Cow next = cows[cowIndex];
				cowIndex++;
				time = next.start + next.wait;
			}
			
			else {
				Cow next = q.poll();
				ans = Math.max(ans, time-next.start);
				time += next.wait;	
			}
		}
		
		w.println(ans);
		w.close();
	}
}
