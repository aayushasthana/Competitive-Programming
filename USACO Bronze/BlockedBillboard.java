import java.util.*;
import java.io.*;

public class BlockedBillboard {

	public static void main(String[] args) throws Exception {
		bill b = new bill();
		b.algo();
		
	}

}

class bill {
	int[][] map;
	Scanner sc;
	PrintWriter w;
	int bill1_x1;
	int bill1_y1;
	int bill1_x2;
	int bill1_y2;
	int bill2_x1;
	int bill2_y1;
	int bill2_x2;
	int bill2_y2;
	int truck_x1;
	int truck_y1;
	int truck_x2;
	int truck_y2;
	int area;
	int overlap;
	
	bill() throws Exception {
		sc = new Scanner(new File("billboard.in"));
		w = new PrintWriter("billboard.out");
	}
	
	void algo() {
		getInputs();
		placeBillboards();
		
		for (int i=truck_x1; i<truck_x2; i++) {
			for (int j=truck_y1; j<truck_y2; j++) {
				if (map[i][j] == 1) {
					overlap++;
				}
			}
		}
		
		System.out.println(area-overlap);
		w.println(area-overlap);
		
		sc.close();
		w.close();
	}
	
	void getInputs() {
		bill1_x1 = sc.nextInt();
		bill1_y1 = sc.nextInt();
		bill1_x2 = sc.nextInt();
		bill1_y2 = sc.nextInt();
		
		bill2_x1 = sc.nextInt();
		bill2_y1 = sc.nextInt();
		bill2_x2 = sc.nextInt();
		bill2_y2 = sc.nextInt();
		
		truck_x1 = sc.nextInt();
		truck_y1 = sc.nextInt();
		truck_x2 = sc.nextInt();
		truck_y2 = sc.nextInt();
		
		map = new int[Math.max(Math.max(bill1_x1, bill2_x2), truck_x2)+1]
					[Math.max(Math.max(bill1_y1, bill2_y2), truck_y2)+1];
	}
	
	void placeBillboards() {
		area = 0;
		
		for (int i=bill1_x1; i<bill1_x2; i++) {
			for (int j=bill1_y1; j<bill1_y2; j++) {
				map[i][j] = 1;
				area++;
			}
		}
		
		for (int i=bill2_x1; i<bill2_x2; i++) {
			for (int j=bill2_y1; j<bill2_y2; j++) {
				map[i][j] = 1;
				area++;
			}
		}
	}
}
