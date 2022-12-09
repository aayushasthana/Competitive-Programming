import java.util.*;

public class Herdle {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		char[][] answer = new char[4][4];
		char[][] guess = new char[4][4];
		
		for (int i=1; i<4; i++) {
			String row = sc.next();
			for (int j=1; j<4; j++) {
				answer[i][j] = row.charAt(j-1);
			}
		}
		
		for (int i=1; i<4; i++) {
			String row = sc.next();
			for (int j=1; j<4; j++) {
				guess[i][j] = row.charAt(j-1);
			}
		}
		
		/*
		for (int i=1; i<4; i++) {
			for (int j=1; j<4; j++) {
				System.out.print(answer[i][j]);
			}
			System.out.println();
		}
		
		for (int i=1; i<4; i++) {
			for (int j=1; j<4; j++) {
				System.out.print(guess[i][j]);
			}
			System.out.println();
		}
		*/
		
		sc.close();
		/*
		 int greenCount = 0;
		 int[] green = new int[27];
		 int[] guessCount = new int[27];
		 int[] answerCount = new int[27];
		 
		 iterate i (1-4):
		 	iterate j (1-4):
		 		if (answer[i][j] == guess[i][j]) {
		 			greenCount++;
		 			green[(int) (answer[i][j])- 64] += 1;
		 		}
		 		
		 		guessCount[(int) (guess[i][j]) - 64] += 1;
		 		answerCount[(int) (answer[i][j]) - 64] += 1;
		 
		 int yellowCount = 0;
		 iterate i (1-27):
		 	yellowCount += min(guessCount[i] - greenCount[i], answerCount[i] - greenCount[i]);
		 	
		 
		 */
		
		int greenCount = 0;
		int[] green = new int[27];
		int[] guessCount = new int[27];
		int[] answerCount = new int[27];
		green[0] = -1;
		guessCount[0] = -1;
		answerCount[0] = -1;
		
		for (int i=1; i<4; i++) {
			for (int j=1; j<4; j++) {
				if (answer[i][j] == guess[i][j]) {
		 			greenCount++;
		 			green[(int) (answer[i][j])- 64] += 1;
		 		}
				
				guessCount[(int) (guess[i][j]) - 64] += 1;
		 		answerCount[(int) (answer[i][j]) - 64] += 1;
			}
		}
		
		int yellowCount = 0;
		for (int i=1; i<27; i++) {
			yellowCount += Math.min(guessCount[i] - green[i], answerCount[i] - green[i]);
		}
		
		System.out.println(greenCount);
		System.out.println(yellowCount);
	}

}