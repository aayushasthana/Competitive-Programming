import java.util.*;
import java.io.*;

public class CowntactTracing {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("tracing.in"));
		PrintWriter w = new PrintWriter("tracing.out");
		
		int N = sc.nextInt();
		int T = sc.nextInt();
		//N is number of cows
		//T is number of interactions
		
		int[] finalStates = new int[N+1];
		finalStates[0] = -1;
		
		String a = sc.next();
		for (int i=0; i<N; i++) {
			if (a.charAt(i) == '1') {
				finalStates[i+1] = 1;
			}
			
			else {
				finalStates[i+1] = 0;
			}
		}
		
		int[] interactionTimes = new int[T+1];
		interactionTimes[0] = -1;
		HashMap<Integer, Integer> cowX = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> cowY = new HashMap<Integer, Integer>();
		
		for (int i=1; i<T+1; i++) {
			interactionTimes[i] = sc.nextInt();
			cowX.put(interactionTimes[i], sc.nextInt());
			cowY.put(interactionTimes[i], sc.nextInt());
		}
		
		sc.close();
		
		Arrays.sort(interactionTimes);
		
		for (int i=1; i<T+1; i++) {
			System.out.print(interactionTimes[i] + " ");
		}
		
		System.out.println();
		
		HashSet<Integer> possibleK = new HashSet<Integer>();
		HashSet<Integer> possibleInitialCows = new HashSet<Integer>();
		
		for (int K=0; K<T+1; K++) {
			for (int I=1; I<N+1; I++) {
				
				int[] currentStates = new int[N+1];
		 		int[] cowK = new int[N+1];
				
		 		currentStates[0] = -1;
		 		currentStates[I] = 1;
		 		cowK[0] = -1;
		 		cowK[I] = K;
		 		
		 		for (int j=1; j<T+1; j++) {
		 			
		 			if (currentStates[cowX.get(interactionTimes[j])] == 1 && currentStates[cowY.get(interactionTimes[j])] == 0) {
		 				
		 				if (cowK[cowX.get(interactionTimes[j])] > 0) {
		 					currentStates[cowY.get(interactionTimes[j])] = 1;
		 					cowK[cowY.get(interactionTimes[j])] = K;
		 					cowK[cowX.get(interactionTimes[j])] -= 1;
		 				}
		 				
		 			}
		 			
		 			else if (currentStates[cowX.get(interactionTimes[j])] == 0 && currentStates[cowY.get(interactionTimes[j])] == 1) {
		 				
		 				
		 				if (cowK[cowY.get(interactionTimes[j])] > 0) {
		 					currentStates[cowX.get(interactionTimes[j])] = 1;
		 					cowK[cowX.get(interactionTimes[j])] = K;
		 					cowK[cowY.get(interactionTimes[j])] -= 1;
		 				}
		 				
		 			}
		 			
		 			else if (currentStates[cowX.get(interactionTimes[j])] == 1 && currentStates[cowY.get(interactionTimes[j])] == 1) {
		 				
		 				
		 				if (cowK[cowY.get(interactionTimes[j])] > 0) {
		 					cowK[cowY.get(interactionTimes[j])] -= 1;
		 				}
		 				
		 				if (cowK[cowX.get(interactionTimes[j])] > 0) {
		 					cowK[cowX.get(interactionTimes[j])] -= 1;
		 				}
		 				
		 			}
		 		}
		 		
		 		boolean equal = true;
		 		for (int x=1; x<N+1; x++) {
		 			if (currentStates[x] != finalStates[x]) {
		 				equal = false;
		 			}
		 		}
		 		
		 		if (equal) {
		 			possibleK.add(K);
		 			possibleInitialCows.add(I);
		 		}
			}
		}
		
		
		System.out.println(possibleK);
		
		if (Collections.max(possibleK) == T) {
			w.println(possibleInitialCows.size() + " " + Collections.min(possibleK) + " Infinity");
		}
		
		else {
			w.println(possibleInitialCows.size() + " " + Collections.min(possibleK) + " " + Collections.max(possibleK));
		}
		
		w.close();
	}

}
