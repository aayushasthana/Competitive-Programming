import java.util.*;
import java.io.*;

public class TeamTicTacToe {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("tttt.in"));
		PrintWriter w = new PrintWriter("tttt.out");
		
		char[][] board = new char[4][4];
		
		for (int i=1; i<4; i++) {
			String temp = sc.next();
			for (int j=1; j<4; j++) {
				board[i][j] = temp.charAt(j-1);
			}
		}
		
		sc.close();
		
		for (int i=1; i<4; i++) {
			System.out.print(board[i][1] + " "+ board[i][2] + " " + board[i][3] + "\n");
		}
		
		int count1 = 0;
		
		for (char i = 'A'; i <= 'Z'; i++) {
			boolean incCount = false;
			
			for (int j=1; j<4; j++) {
				if (board[j][1] == i && board[j][2] == i && board[j][3] == i) {
					incCount = true;
				}
				
				if (board[1][j] == i && board[2][j] == i && board[3][j] == i) {
					incCount = true;
				}
			}
			
			if (board[1][1] == i && board[2][2] == i && board[3][3] == i) {
				incCount = true;
			}
			
			if (board[3][1] == i && board[2][2] == i && board[1][3] == i) {
				incCount = true;
			}
			
			if (incCount) {
				count1++;
			}
		}
		
		w.println(count1);
		
		int count2 = 0;
		
		for (char i = 'A'; i <= 'Z'; i++) {
			for (char j = (char)(i + 1); j <= 'Z'; j++) {
				boolean incCount = false;
				
				for (int k=1; k<4; k++) {
					if (board[k][1] == board[k][2] && board[k][2] == board[k][3]) {
						continue;
					}
					
					else if (checkCell(i, j, board[k][1]) && checkCell(i, j, board[k][2]) && checkCell(i, j, board[k][3])) {
						incCount = true;
					}
				}
					
				for (int k=1; k<4; k++) {
					if (board[1][k] == board[2][k] && board[2][k] == board[3][k]) {
						continue;
					}
					
					else if (checkCell(i, j, board[1][k]) && checkCell(i, j, board[2][k]) && checkCell(i, j, board[3][k])) {
						incCount = true;
					}
				}
				
				if (board[1][1] == board[2][2] && board[2][2] == board[3][3]) {
					//continue;
				}
				
				else if (checkCell(i, j, board[1][1]) && checkCell(i,j,board[2][2]) && checkCell(i,j,board[3][3])) {
					incCount = true;
				}
				
				if (board[1][3] == board[2][2] && board[2][2] == board[3][1]) {
					//continue;
				}
				
				else if (checkCell(i, j, board[1][3]) && checkCell(i,j,board[2][2]) && checkCell(i,j,board[3][1])) {
					incCount = true;
				}
				
				if (incCount) {
					count2++;
				}
			}
		}
		
		w.println(count2);
		
		w.close();
	}
	
	public static boolean checkCell(char i, char j, char cell) {
		return (i == cell || j == cell);
	}
}
