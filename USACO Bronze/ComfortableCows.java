import java.util.*;

public class ComfortableCows {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		/*
		 * 	Iterate through cows:
		 * 		place current cow on the grid
		 * 		if curr cow is comfy
		 * 			increase count
		 * 		check # of surrounding cows for each neighbor cow:
		 * 			if 3:
		 * 				count++
		 * 			if 4:
		 * 				count--
		 */
		
		int count = 0;
		int[][] grid = new int[1010][1010];
		int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		
		for (int i=0; i<N; i++) {
			int X = sc.nextInt()+2;
			int Y = sc.nextInt()+2;
			grid[X][Y]++;
			
			if (grid[X+1][Y] + grid[X][Y+1] + grid[X-1][Y] + grid[X][Y-1] == 3) {
				count++;
			}
			
			for (int j=0; j<4; j++) {
				int currX = X + directions[j][0];
				int currY = Y + directions[j][1];
				int surroundingCows = grid[currX+1][currY] + grid[currX][currY+1] + grid[currX-1][currY] + grid[currX][currY-1];
				
				if (surroundingCows == 3 && grid[currX][currY] == 1) {
					count++;
				} else if (surroundingCows == 4 && grid[currX][currY] == 1) {
					count--;
				}
			}
			System.out.println(count);
		}
		
		
		
		sc.close();
		
	}

}
