package basic.recursion.backtracking;

import java.util.*;

public class Nqueen {
	public static void saveBoard(List<List<String>>allBoard,char[][] board) {
		
		String row="";
		List<String>newBoard=new ArrayList<>();
		
		for(int i=0;i<board.length;i++) {
			row="";
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]=='Q') {
					row+='Q';
				}else {
					row+='.';
				}
			}
			newBoard.add(row);
		}
		allBoard.add(newBoard);
		
	}
	public static Boolean isSafe(char[][] board,int row,int col) {
		
		//no queen in horizontal row
		for(int j=0;j<board.length;j++) {
			//no queen in horizontal row
			if(board[row][j]=='Q') {
				return false;
			}
			// no queen in vertical row
			if(board[j][col]=='Q') {
				return false;
			}
		}
		
//		for(int j=0;j<board.length;j++) {
//			if(board[j][col]=='Q') {
//				return false;
//			}
//		}
		//upper left
		int r=row;
		for(int c=col;c>=0 && r>=0;c--,r--) {
			if(board[r][c]=='Q') {
				return false;
			}
		}
		//upper right
		r=row;
		for(int c=col;c<board.length && r>=0;r--,c++) {
			if(board[r][c]=='Q') {
				return false;
			} 
		}
		//lower left
		r=row;
		for(int c=col;c>=0 && r<board.length ; c--, r++) {
			if(board[r][c]=='Q') {
				return false;
			}
		}
		//lower rigth
		r=row;
		for(int c=col;c<board.length && r<board.length;c++,r++) {
			if(board[r][c]=='Q') {
				return false;
			}
		}
		return true;
		
	}

	public static void helper(List<List<String>>allBoard,char[][] board,int col) {
		
		if(col==board.length) {
			saveBoard(allBoard,board);
			return;
		}
		for(int row=0;row<board.length;row++) {
			if(isSafe(board,row,col)) {
				board[row][col]='Q';
				helper(allBoard,board,col+1);
				board[row][col]='.';
			}
		}
	}
	public static List<List<String>> solveNqueen(int n){
		
		List<List<String>> allBoard =new ArrayList<>();
		char[][]board=new char[n][n];
		helper(allBoard,board,0);
		return allBoard;
		
	}
	public static void main(String[] args) {
		int n=4;
		List<List<String>> allBoard=solveNqueen(n);
		System.out.println(allBoard);
		
		
	}
}
