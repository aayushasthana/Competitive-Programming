import java.util.*;
import java.io.*;

public class Problem7PromotionCounting {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("promote.in"));
		PrintWriter w = new PrintWriter("promote.out");
		
		int[] before = new int[4];
		int[] after = new int[4];
		
		for (int i=0; i<4; i++) {
			before[i] = sc.nextInt();
			after[i] = sc.nextInt();
		}
		
		sc.close();
		
		int promoPlat = after[3] - before[3];
		//System.out.println(promoPlat);
		
		int goldLeft = before[2] - promoPlat;
		//System.out.println(goldLeft);
		
		int promoGold = after[2] - goldLeft;
		//System.out.println(promoGold);
		
		int silverLeft = before[1] - promoGold;
		//System.out.println(silverLeft);
		
		int promoSilver = after[1] - silverLeft;
		//System.out.println(promoSilver);
		
		w.println(promoSilver);
		w.println(promoGold);
		w.println(promoPlat);
		 
		w.close();
	}

}
