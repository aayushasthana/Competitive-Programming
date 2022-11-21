import java.util.*;
import java.io.*;

public class BessieSlowsDown {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("slowdown.in"));
		PrintWriter w = new PrintWriter("slowdown.out");

		int N = sc.nextInt();
		List<Long> timeEvents = new ArrayList<Long>();
		List<Long> distEvents = new ArrayList<Long>();
		
		for (int i=0; i<N; i++) {
			if (sc.next().charAt(0) == 'T') {
				timeEvents.add(sc.nextLong());
			} else {
				distEvents.add(sc.nextLong());
			}
		}
		
		sc.close();
		
		Collections.sort(timeEvents);
		Collections.sort(distEvents);
		
		int tIndex = 0;
		int dIndex = 0;
		double prevTime = 0;
		double time = 0;
		double prevDist = 0;
		double dist = 0;
		int prevSd = 1;
		int sd = 1;
		boolean over = false;
		
		for (int i=0; i<N; i++) {
			if (dIndex == distEvents.size()) {
				time += timeEvents.get(tIndex) - time;
				dist += (timeEvents.get(tIndex) - prevTime) / sd;
				tIndex++;
				sd++;
			} else if (tIndex == timeEvents.size()) {
				time += (distEvents.get(dIndex) - dist) * sd;
				dist = distEvents.get(dIndex);
				dIndex++;
				sd++;
			} else {
				double t1 = timeEvents.get(tIndex) - time;
				double t2 = (distEvents.get(dIndex) - dist) * sd;
				if (t1 < t2) {
					time += timeEvents.get(tIndex) - time;
					dist += (timeEvents.get(tIndex) - prevTime) / sd;
					tIndex++;
					sd++;
				} else {
					time += (distEvents.get(dIndex) - dist) * sd;
					dist = distEvents.get(dIndex);
					dIndex++;
					sd++;
				}
			}
			
			if (dist >= 1000) {
				over = true;
				break;
			}
			
			prevSd = sd;
			prevDist = dist;
			prevTime = time;
		}
		
		//Calculate remaining time:
		if (over) {
			time += (1000-prevDist) * prevSd;
		} else {
			time += (1000-dist) * sd;
		}

		w.println((long)(time+0.5));
		
		w.close();
	}

}
