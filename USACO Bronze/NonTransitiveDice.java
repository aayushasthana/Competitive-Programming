import java.util.*;

public class Problem2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i=0; i<T; i++) {
			int[] diceA = new int[4];
			int[] diceB = new int[4];
			
			for (int j=0; j<4; j++) {
				diceA[j] = sc.nextInt();
			}
			
			for (int j=0; j<4; j++) {
				diceB[j] = sc.nextInt();
			}
			
			Arrays.sort(diceA);
			Arrays.sort(diceB);
			
			//int[] testDiceA = {4, 5, 6, 7};
			//int[] testDiceB = {2, 4, 5, 10};
			//int[] testDiceC = {1, 4, 8, 9};
			
			boolean possible = false;
			int[] diceC = new int[4];
			for (int a=1; a<=10; a++) {
				for (int b=1; b<=10; b++) {
					for (int c=1; c<=10; c++) {
						for (int d=1; d<=10; d++) {
							diceC[0] = a;
							diceC[1] = b;
							diceC[2] = c;
							diceC[3] = d;
							
							Arrays.sort(diceC);
							
							if (firstBeatsSecond(diceA, diceB) && firstBeatsSecond(diceB, diceC) && firstBeatsSecond(diceC, diceA)) {
								possible = true;
							}
							
							else if (firstBeatsSecond(diceA, diceC) && firstBeatsSecond(diceC, diceB) && firstBeatsSecond(diceB, diceA)) {
								possible = true;
							}
						}
					}
				}
			}
			
			if (possible) {
				System.out.println("yes");
			}
			
			else {
				System.out.println("no");
			}
		}
		
		sc.close();
		
	}
	
	public static boolean firstBeatsSecond(int[] first, int[] second) {
		int firstCount = 0;
		int secondCount = 0;
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				if (first[i] > second[j]) {
					firstCount++;
				}
				
				else if (first[i] < second[j]) {
					secondCount++;
				}
			}
		}
		
		if (firstCount > secondCount) {
			return true;
		}
		
		else {
			return false;
		}
	}
}
