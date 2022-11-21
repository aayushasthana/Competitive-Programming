import java.util.*;
import java.io.*;

public class Problem34DontBeLast {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("notlast.in"));
		PrintWriter w = new PrintWriter("notlast.out");
		
		/*
		 sort milk in new arraylist	
		 
		 iterate through sorted arraylist:
		 	chosenMilk
		 	find 2nd smallest milk that is not tied:
		 		check if previous element is equal to current:
		 			if so, do nothing
		 		else:
		 			chosenMilk = current element
		 			break;
		 
		 if chosenMilk is 0:
		 	print "Tie" and end code
		 
		 
		 else iterate through normal array:
		 	variable count2
		 	variable chosenCow
		 	if chosenMilk = cows[i]:
		 		count2++
		 		if this is first count2 increment:
		 			chosenCow = i;
		 	
		 	if count2 is greater that 1:
		 		print "Tie" and end
		 		
		 	else check which cow is chosen:
		 		print chosen cow and end
		 */
		
		
		int cows[] = new int[7];
		
		int N = sc.nextInt();

		for (int i=0; i<N; i++) {
			String name = sc.next();
			int add = sc.nextInt();
			
			if (name.equals("Bessie")) {
				cows[0] += add;
			} else if (name.equals("Elsie")) {
				cows[1] += add;
			} else if (name.equals("Daisy")) {
				cows[2] += add;
			} else if (name.equals("Gertie")) {
				cows[3] += add;
			} else if (name.equals("Annabelle")) {
				cows[4] += add;
			} else if (name.equals("Maggie")) {
				cows[5] += add;
			} else if (name.equals("Henrietta")) {
				cows[6] += add;
			}
		}
		
		sc.close();
		
		ArrayList<Integer> possible = new ArrayList<Integer>();
		for (int i=0; i<7; i++) {
			possible.add(cows[i]);
		}

		Collections.sort(possible);
		
		System.out.println(possible);
		
		int prev = possible.get(0);
		int chosenMilk = 0;
		
		for (int i=0; i<7; i++) {
			if (prev == possible.get(i)) {
				
			} else {
				chosenMilk = possible.get(i);
				break;
			}
		}
		
		System.out.println(chosenMilk);
		
		if (chosenMilk == 0) {
			w.print("Tie");
		} 
		
		else {
			int count2 = 0;
			int chosenCow = 0;
			
			for (int i=0; i<7; i++) {
				if (cows[i] == chosenMilk) {
					count2++;
					if (count2 == 1) {
						chosenCow = i;
					}
				}
			}
			
			if (count2 > 1) {
				w.print("Tie");
			} else if (chosenCow == 0) {
				w.print("Bessie");
			} else if (chosenCow == 1) {
				w.print("Elsie");
			} else if (chosenCow == 2) {
				w.print("Daisy");
			} else if (chosenCow == 3) {
				w.print("Gertie");
			} else if (chosenCow == 4) {
				w.print("Annabelle");
			} else if (chosenCow == 5) {
				w.print("Maggie");
			} else if (chosenCow == 6) {
				w.print("Henrietta");
			} 
		}
		
		
		
		
		w.close();
		
	}

}
