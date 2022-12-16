import java.util.*;
import java.io.*;

import java.util.*;
import java.io.*;

public class TheGreatRevegetation {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new File("revegetate.in"));
    PrintWriter w = new PrintWriter("revegetate.out");

    int N = sc.nextInt();
    int M = sc.nextInt();
    boolean[][] possible = new boolean[N+1][5];
    for (int i=0; i<N+1; i++) {
      for (int j=0; j<5; j++) {
        possible[i][j] = true;
      }
    }
    
    boolean[][] intersects = new boolean[N+1][N+1];
    for (int i=0; i<M; i++) {
      int num1 = sc.nextInt();
      int num2 = sc.nextInt();
      intersects[num1][num2] = true;
      intersects[num2][num1] = true;
    }
    
    int[] finalArr = new int[N+1];
    for (int i=1; i<N+1; i++) {
      int pos = -1;
      
      //Place Earliest
      for (int j=1; j<5; j++) {
        if (possible[i][j]) {
          pos = j;
          finalArr[i] = j;
          break;
        }
      }

      //Update Possible Arr
      for (int j=1; j<N+1; j++) {
        if (intersects[i][j]) {
          possible[j][pos] = false;
        }
      }
    }
    
    String retval = "";
    for (int i=1; i<N+1; i++) retval += finalArr[i];
    w.println(retval);
    
    sc.close();
    w.close();
  }
}
