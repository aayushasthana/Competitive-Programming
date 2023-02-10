import java.util.*;
import java.io.*;

public class FieldReduction {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
		PrintWriter w = new PrintWriter("reduce.out");
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//try all combinations of {3 X max, 3 X min, 3 Y max, 3 Y min}
		int N = Integer.parseInt(st.nextToken());
		int[][] points = new int[N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] removablePoints = new int[16][2];
		
		//add x's
		Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
		for (int i=0; i<4; i++) {
			int[] curr = {points[i][0], points[i][1]};
			int[] curr2 = {points[N-1-i][0], points[N-1-i][1]};
			removablePoints[i] = curr;
			removablePoints[16-1-i] = curr2;
		}
		
		//add y's
		Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
		for (int i=0; i<4; i++) {
			int[] curr = {points[i][0], points[i][1]};
			int[] curr2 = {points[N-1-i][0], points[N-1-i][1]};
			removablePoints[i+4] = curr;
			removablePoints[16-1-i-4] = curr2;
		}
		
		long minArea = Long.MAX_VALUE;
		for (int i=0; i<16; i++) {
			for (int j=i+1; j<16; j++) {
				for (int k=j+1; k<16; k++) {
					if (removablePoints[i][0] == removablePoints[j][0] && removablePoints[i][1] == removablePoints[j][1]) continue;
					if (removablePoints[i][0] == removablePoints[k][0] && removablePoints[i][1] == removablePoints[k][1]) continue;
					if (removablePoints[j][0] == removablePoints[k][0] && removablePoints[j][1] == removablePoints[k][1]) continue;
					
					boolean[] notUseable = new boolean[16];
					for (int a=0; a<16; a++) {
						if (removablePoints[i][0] == removablePoints[a][0] && removablePoints[i][1] == removablePoints[a][1]) notUseable[a] = true;
						if (removablePoints[j][0] == removablePoints[a][0] && removablePoints[j][1] == removablePoints[a][1]) notUseable[a] = true;
						if (removablePoints[k][0] == removablePoints[a][0] && removablePoints[k][1] == removablePoints[a][1]) notUseable[a] = true;
					}
					
					long minX = Long.MAX_VALUE;
					long maxX = Long.MIN_VALUE;
					long minY = Long.MAX_VALUE;
					long maxY = Long.MIN_VALUE;
					
					for (int a=0; a<16; a++) {
						if (notUseable[a]) continue;
						minX = Math.min(removablePoints[a][0], minX);
						maxX = Math.max(removablePoints[a][0], maxX);
						minY = Math.min(removablePoints[a][1], minY);
						maxY = Math.max(removablePoints[a][1], maxY);
					}
					
					minArea = Math.min(minArea, (maxX-minX) * (maxY-minY));
				}
			}
		}
		
		w.println(minArea);
		w.close();
	}
}
