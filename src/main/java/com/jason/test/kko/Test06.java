package com.jason.test.kko;

import java.util.HashSet;
import java.util.Set;

public class Test06 {


    public static void main(String[] args) {

        String[] input1 =
                {"CCBDE",
                 "AAADE",
                 "AAABF",
                 "CCBBF"};
        System.out.println("score : " + playGame(createBoard(4, 5, input1)));
        System.out.println();
        System.out.println();
        System.out.println("==========================");
        System.out.println();
        
        
        
        
        String[] input2 = {
        		"TTTANT", 
        		"RRFACC", 
        		"RRRFCC", 
        		"TRRRAA", 
        		"TTMMMF",
        		"TMMTTJ"};
        System.out.println("score : " + playGame(createBoard(6, 6, input2)));
        System.out.println();
        System.out.println();
        System.out.println("==========================");
        System.out.println();
    }

    public static char[][] createBoard(int height, int width, String[] inputTable) {

        char[][] board = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = inputTable[i].charAt(j);
            }
        }

        return board;
    }

    public static void printBoard(char[][] board) {

        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static int playGame(char[][] board) {
    	
    	int score = 0;
    	
    	Set<String> set = new HashSet<>();
    	
        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[i].length - 1; j++) {
            	
            	char src = board[i][j];
            	
            	if (src != ' '
            			&& src == board[i + 1][j] 
            			&& src == board[i + 1][j + 1]
            			&& src == board[i][j + 1]) {
            		
            		set.add(new Coordinate(i, j).toString());
            		set.add(new Coordinate(i + 1, j).toString());
            		set.add(new Coordinate(i, j + 1).toString());
            		set.add(new Coordinate(i + 1, j + 1).toString());
            	}
            }
        }
        printBoard(board);
        
        if (set.size() != 0) {
        	score += set.size();
        	removeBlock(board, set);
        	score += playGame(board);
        }
//        printBoard(board);
        
    	return score;

    }
    
    public static void removeBlock(char[][] board, Set<String> set) {
    	
    	// remove block
    	for (String coordStr : set) {
    		String[] coord = coordStr.split("/");
    		int x = Integer.parseInt(coord[0]);
    		int y = Integer.parseInt(coord[1]);
    		board[x][y] = ' ';
		}
//    	printBoard(board);
    	

    	// down block
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
            	if (board[i][j] == ' ') {
            		for (int k = i - 1; k >= 0; k--) {
            			if (board[k][j] != ' ') {
            				board[i][j] = board[k][j]; // 내리고
            				board[k][j] = ' '; // 지우고
//            		    	printBoard(board);
            			}
            		}
            	}
            }
        }
    }

    public static class Coordinate {
    	public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
    	int x;
    	int y;
    	@Override
    	public String toString() {
    		return x + "/" + y;
    	}
    }

}