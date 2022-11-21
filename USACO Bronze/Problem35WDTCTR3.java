import java.util.*;
import java.io.*;

public class Problem35WDTCTR3 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("cowqueue.in"));
		PrintWriter w = new PrintWriter("cowqueue.out");
		
		int N = sc.nextInt();
		int[] queue = new int[N];
		HashMap<Integer, Integer> requiredTimes = new HashMap<Integer, Integer>();
		
		for (int i=0; i<N; i++) {
			queue[i] = sc.nextInt();
			requiredTimes.put(queue[i], sc.nextInt());
		}
		
		sc.close();
		
		int time = 0;
		Arrays.sort(queue);
		
		for (int i=0; i<N; i++) {
			if (time > queue[i]) {
				time += requiredTimes.get(queue[i]);
			} else {
				time = queue[i] + requiredTimes.get(queue[i]);
			}
		}
		
		w.print(time);
		w.close();
		
		/*
		 variable time = 0;
		 queue = sorted cow start times
		 
		 iterate through queue:
		 	if time > current cow start time:
		 		time += current cow required time
		 	else:
		 		time = current cow start time + current cow required time
		 */
	}

}
