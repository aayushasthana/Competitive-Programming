import java.util.*;
import java.io.*;

public class BovineBallet {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("ballet.in"));
		PrintWriter w = new PrintWriter("ballet.out");
		
		int N = sc.nextInt();
		//initial position: FR = (1, 1), FL = (0, 1), RR = (1, 0), RL = (0, 0)
		//0 = FR, 1 = FL, 2 = RR, 3 = RL 
		
		Foot[] feet = new Foot[4];
		feet[0] = new Foot(1, 1);
		feet[1] = new Foot(0, 1);
		feet[2] = new Foot(1, 0);
		feet[3] = new Foot(0, 0);
		
		Map<String, Integer> feetNum = new HashMap<String, Integer>();
		feetNum.put("FR", 0);
		feetNum.put("FL", 1);
		feetNum.put("RR", 2);
		feetNum.put("RL", 3);
		
		int maxX=1;
		int maxY=1;
		int minX=0;
		int minY=0;
		char dir = 'N';
		boolean possible = true;
		
		for (int i=0; i<N; i++) {
			String input = sc.next();
			String inFoot = input.substring(0,2);
			String inst = input.substring(2,3);
			int foot = feetNum.get(inFoot);
			
			//basic movements
			if (dir == 'N') {
				if (inst.equals("F")) feet[foot].y++;
				if (inst.equals("B")) feet[foot].y--;
				if (inst.equals("R")) feet[foot].x++;
				if (inst.equals("L")) feet[foot].x--;
			}
			
			if (dir == 'S') {
				if (inst.equals("F")) feet[foot].y--;
				if (inst.equals("B")) feet[foot].y++;
				if (inst.equals("R")) feet[foot].x--;
				if (inst.equals("L")) feet[foot].x++;
			}
			
			if (dir == 'E') {
				if (inst.equals("F")) feet[foot].x++;
				if (inst.equals("B")) feet[foot].x--;
				if (inst.equals("R")) feet[foot].y--;
				if (inst.equals("L")) feet[foot].y++;
			}
			
			if (dir == 'W') {
				if (inst.equals("F")) feet[foot].x--;
				if (inst.equals("B")) feet[foot].x++;
				if (inst.equals("R")) feet[foot].y++;
				if (inst.equals("L")) feet[foot].y--;
			}
			
			//pivot
			if (inst.equals("P")) {
				if (dir == 'N') dir = 'E';
				else if (dir == 'E') dir = 'S';
				else if (dir == 'S') dir = 'W';
				else if (dir == 'W') dir = 'N';
				
				for (int j=0; j<4; j++) {
					if (j==foot) continue;
					
					int yDist = feet[j].y - feet[foot].y;
					int xDist = feet[j].x - feet[foot].x;
					
					feet[j].x = feet[foot].x + yDist;
					feet[j].y = feet[foot].y - xDist;
				}
			}
			
			//check if not possible
			for (int j=0; j<4; j++) {
				for (int k=j+1; k<4; k++) {
					if (feet[j].x == feet[k].x && feet[j].y == feet[k].y) {
						possible = false;
					}
				}
			}
			
			//update max and min
			for (int j=0; j<4; j++) {
				maxX = Math.max(feet[j].x, maxX);
				maxY = Math.max(feet[j].y, maxY);
				minX = Math.min(feet[j].x, minX);
				minY = Math.min(feet[j].y, minY);
			}
		}
		
		sc.close();
		
		if (!possible) w.println(-1);
		else w.println((maxX-minX + 1) * (maxY-minY + 1));
		
		w.close();
	}

	public static class Foot {
		public int x;
		public int y;
		
		public Foot(int myX, int myY) {
			x = myX;
			y = myY;
		}
	}
}
