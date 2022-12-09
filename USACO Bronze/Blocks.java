import java.util.*;

public class Blocks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		char[] dice1 = new char[6];
		char[] dice2 = new char[6];
		char[] dice3 = new char[6];
		char[] dice4 = new char[6];
		
		dice1 = sc.next().toCharArray();
		dice2 = sc.next().toCharArray();
		dice3 = sc.next().toCharArray();
		dice4 = sc.next().toCharArray();
		
		String[] words = new String[N];
		for (int i=0; i<N; i++) {
			words[i] = sc.next();
		}
		
		sc.close();
		
		/*
		 iterate through words:
		 	iterate through letters of word:
		 		make array of dice with the letter
		 	
		 	iterate through letter1 set:
		 		iterate through letter2 set:
		 			iterate through letter3 set:
		 				if all are true:
		 					boolean works = true
		 		
		 */
		
		for (int i=0; i<N; i++) {
			char[] word = words[i].toCharArray();
			
			int[][] letterSets = new int[word.length][4];
			
			for (int j=0; j<word.length; j++) {
				char letter = word[j];
				for (int k=0; k<6; k++) {
					if (dice1[k] == letter) {
						letterSets[j][0] = 1;
					}
					
					if (dice2[k] == letter) {
						letterSets[j][1] = 1;
					}
					
					if (dice3[k] == letter) {
						letterSets[j][2] = 1;
					}
					
					if (dice4[k] == letter) {
						letterSets[j][3] = 1;
					}
				}
			}
			
			/*
			System.out.println("WORD: "+ words[i]);
			
			for (int j=0; j<word.length; j++) {
				System.out.print(j+": ");
				for (int k=0; k<4; k++) {
					System.out.print(letterSets[j][k] + " ");
				}
				System.out.println();
			}
			*/
			
			boolean validWord = false;
			for (int a=0; a<4; a++) {
				if (letterSets[0][a] == 1 && word.length > 1) {
					//System.out.println("letter 1 works");
					for (int b=0; b<4; b++) {
						if (b==a) {
							continue;
						}
						
						else if (letterSets[1][b] == 1 && word.length > 2) {
							//System.out.println("letter 2 works");
							for (int c=0; c<4; c++) {
								if (c==b || c==a) {
									continue;
								}
								
								else if (letterSets[2][c] == 1 && word.length > 3) {
									//System.out.println("letter 3 works");
									for (int d=0; d<4; d++) {
										//System.out.println("a: "+a+", b: "+b+", c: "+c+", d: "+d);
										if (d == c || d == b || d == a) {
											continue;
										}
										
										
										else if (letterSets[3][d] == 1) {
											//System.out.println("letter 4 works");
											validWord = true;
										}
										
									}
								}
								
								else if (letterSets[2][c] == 1) {
									//System.out.println("IN");
									validWord = true;
								}
							}
						}
						
						else if (letterSets[1][b] == 1) {
							validWord = true;
						}
					}
					
				}
				
				else if (letterSets[0][a] == 1) {
					validWord = true;
				}
 			}
			
			if (validWord) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
			
			//System.out.println();
		}
	}
}