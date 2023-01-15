import java.util.*;
import java.io.*;

public class Race {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("race.in"));
		PrintWriter w = new PrintWriter("race.out");
		int K = sc.nextInt();
		int N = sc.nextInt();
		for (int i=0; i<N; i++) {
			int X = sc.nextInt();
			int currDist = 0;
			int currSpeed = 1;
			int time = 0;
			
			while (true) {
				currDist += currSpeed;
				time++;
				
				if (currDist >= K) break;
				
				if (currSpeed >= X) {
					currDist += currSpeed;
					time++;
				}
				
				if (currDist >= K) break;
				
				currSpeed++;
			}
			
			w.println(time);
		}
		
		sc.close();
		w.close();
	}

}
