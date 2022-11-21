import java.util.*;
import java.io.*;

public class Problem33BlockedBillboardII {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("billboard.in"));
		PrintWriter w = new PrintWriter("billboard.out");
		
		int lawnX1 = sc.nextInt();
		int lawnY1 = sc.nextInt();
		int lawnX2 = sc.nextInt();
		int lawnY2 = sc.nextInt();
		int cowX1 = sc.nextInt();
		int cowY1 = sc.nextInt();
		int cowX2 = sc.nextInt();
		int cowY2 = sc.nextInt();
		
		sc.close();
		
		/*
		 if x1 <= a1 and x2 >= a2:
		 	tarpArea = lawnmower board area - overlap
		 	
		 else if y1 <= b1 and y2 >= b2:
		 	tarpArea = lawnmower board area - overlap
		 	
		 else:
		 	tarpArea = lawnmower board area
		 */
		
		int tarpArea = 0;
		int overlapX = Math.max(0, Math.min(cowX2, lawnX2) - Math.max(cowX1, lawnX1));
		int overlapY = Math.max(0, Math.min(cowY2, lawnY2) - Math.max(cowY1, lawnY1));	
		int overlap = overlapX * overlapY;
		int lawnmowerArea = (lawnX2 - lawnX1) * (lawnY2 - lawnY1);
		
		
		if (cowX1 <= lawnX1 && cowX2 >= lawnX2) {
			tarpArea = lawnmowerArea - overlap;
		} else if (cowY1 <= lawnY1 && cowY2 >= lawnY2) {
			tarpArea = lawnmowerArea - overlap;
		} else {
			tarpArea = lawnmowerArea;
		}
		
		w.print(tarpArea);
		w.close();
	}

}
