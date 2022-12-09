import java.util.*;

public class Photoshoot2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] initial = new int[N+1];
		int[] goal = new int[N+1];
		initial[0] = -1;
		goal[0] = -1;
		
		for (int i=1; i<N+1; i++) {
			initial[i] = sc.nextInt();
		}
		
		for (int i=1; i<N+1; i++) {
			goal[i] = sc.nextInt();
		}
		
		HashMap<Integer, Integer> converter = new HashMap<Integer, Integer>();
		
		for (int i=1; i<N+1; i++) {
			converter.put(goal[i], i);
		}
		
		int[] answerArray = new int[N+1];
		answerArray[0] = -1;
		
		for (int i=1; i<N+1; i++) {
			answerArray[i] = converter.get(initial[i]);
		}
		
		int prev = 0;
		int count = 0;
		for (int i=1; i<N+1; i++) {
			if (answerArray[i] > prev) {
				count++;
				prev = answerArray[i];
			}
		}
		
		System.out.println(N-count);
	}

}
