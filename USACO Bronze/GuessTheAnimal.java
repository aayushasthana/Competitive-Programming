import java.util.*;
import java.io.*;

public class GuessTheAnimal {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("guess.in"));
		PrintWriter w = new PrintWriter("guess.out");
		
		int N = sc.nextInt();
		
		ArrayList<String>[] animals = new ArrayList[N];
		
		for (int i=0; i<N; i++) {
			String name = sc.next();
			int amount = sc.nextInt();
			animals[i] = new ArrayList<String>();
			
			for (int j=0; j<amount; j++) {
				animals[i].add(sc.next());
			}
		}
		
		int answer = -1;
		
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				int sum = 0;
				for (int k=0; k<animals[i].size(); k++) {
					for (int l=0; l<animals[j].size(); l++) {
						if (animals[i].get(k).equals(animals[j].get(l))) {
							sum++;
						}
					}
				}
				
				answer = Math.max(answer, sum);
			}
		}
		
		w.print(answer+1);
		
		w.close();
		sc.close();
	}

}

