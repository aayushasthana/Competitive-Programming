import java.io.*;
import java.util.*;

public class ContaminatedMilk {

	public static void main(String[] args) throws Exception {
		/*
		 dosesNeeded = 0;
		 
		 for every single milk, if this is this is the bad milk, how many doses do we need
		 
		 
		 for i = 1...M:
		 	possiblyBadMilk = true;
		 	check if it is possible for milk i to be bad milk:
		 	
			 	for j = 1...S:
			 		sickPerson = sickPersonArray[j]
			 		sickTime = sickTimeArray[j]
			 		
			 		drankBadMilkBeforeSick = false
			 		
			 		for k = 1...D:
			 			if sickPerson == eventPerson[k] and i == eventMilk[k] and eventTime[k] < sickTime:
			 				drankBadMilkBeforeSick = true
			 		
			 		if drankBadMilkBeforeSick == false:
			 			possiblyBadMilk = false;
		 	
		 	
			 	if possiblyBadMilk:
			 		counter = 0;
			 		
			 		//count number of distinct people who drank this milk
			 		for j = 1...N:
			 			drankMilk = false;
			 			for k = 1...D:
			 				if j == eventPerson[k] and i == eventMilk[k]:
			 					drankMilk = true
			 		
			 			if drank_milk:
			 				counter++;
			 	
			 	dosesNeeded = max(dosesNeeded, counter);
		*/
		
		Scanner sc = new Scanner(new File("badmilk.in"));
		PrintWriter w = new PrintWriter("badmilk.out");
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int D = sc.nextInt();
		int S = sc.nextInt();
		
		int[] eventPerson = new int[D];
		int[] eventMilk = new int[D];
		int[] eventTime = new int[D];
		
		for (int i=0; i<D; i++) {
			eventPerson[i] = sc.nextInt();
			eventMilk[i] = sc.nextInt();
			eventTime[i] = sc.nextInt();
		}
		
		int[] sickPersonArray = new int[S];
		int[] sickTimeArray = new int[S];
		
		for (int i=0; i<S; i++) {
			sickPersonArray[i] = sc.nextInt();
			sickTimeArray[i] = sc.nextInt();
		}
		
		sc.close();
		
		int dosesNeeded = 0;
		
		for (int i=1; i<=M; i++) {
			boolean possiblyBadMilk = true;
			
			for (int j=0; j<S; j++) {
				boolean drankMilkBefore = false;
				for (int k=0; k<D; k++) {
					
					
					if (eventPerson[k] == sickPersonArray[j] && i == eventMilk[k] && eventTime[k] < sickTimeArray[j]) {
						drankMilkBefore = true;
					}
					
				}
				
				if (drankMilkBefore == false) {
					possiblyBadMilk = false;
				}
			}
			
			if (possiblyBadMilk) {
				int count = 0;
				for (int j=1; j<=N; j++) {
					boolean drankMilk = false;
					
					for (int k=0; k<D; k++) {
						if (j==eventPerson[k] && i==eventMilk[k]) {
							drankMilk = true;
						}
					}
					
					if (drankMilk) {
						count++;
					}
				}
				
				dosesNeeded = Math.max(count, dosesNeeded);
			}
		}
		
		w.println(dosesNeeded);
		
		w.close();
	}

}
