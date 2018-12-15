package com.jason.test.kko;

import java.util.ArrayList;
import java.util.List;

public class Temp5 {

	// 4 5 ["CCBDE", "AAADE", "AAABF", "CCBBF"] 14
	// 6 6 ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"] 15
	public static void main(String[] args) {

		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		// String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF",
		// "TMMTTJ"};
		int a = board.length;
		int b = board[0].length();

		String[][] arrayBlock = new String[a][b];
		// {{"C","C","B", "D", "E"}, {"A","A","A","D","E"}, {"A","A","A","B","F"},
		// {"C","C","B","B","F"}};
		// 이차원 배열
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				arrayBlock[i][j] = board[i].substring(j, j + 1);
			}
		}

		String[][] resultBlock;
		for (;;) {
			resultBlock = blockGame(arrayBlock);
			if (isSameArray(resultBlock, blockGame(resultBlock)))
				break;
		}
		// resultBlock = blockGame(arrayBlock);

		// ----------------------------------------------------
		for (int i = 0; i < resultBlock.length; i++) {
			for (int j = 0; j < resultBlock[i].length; j++) {
				System.out.print(resultBlock[i][j]);
			}
			System.out.println("");
		}
		for (int i = 0; i < arrayBlock.length; i++) {
			for (int j = 0; j < arrayBlock[i].length; j++) {
				System.out.print(arrayBlock[i][j]);
			}
			System.out.println("");
		}
		// -------------------------------------------------------

		int result = getAnswer(arrayBlock);

		System.out.println(result);
	}

	public static String[][] blockGame(String[][] block) {

		// {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		String[][] blockResult = block;

		List<Integer> row = new ArrayList<>();
		List<Integer> col = new ArrayList<>();

		int index = 0;

		// 주변 4개되는지 확인 후 인덱스만 저장
		for (int i = 0; i < blockResult.length - 1; i++) {
			for (int j = 0; j < blockResult[i].length - 1; j++) {
				if ((!"0".equals(blockResult[i][j]) && blockResult[i][j].equals(blockResult[i][j + 1]))
						&& (blockResult[i][j].equals(blockResult[i + 1][j]))
						&& (blockResult[i][j].equals(blockResult[i + 1][j + 1]))) {
					row.add(i);
					col.add(j);
					System.out.println("i : " + i + ", j : " + j);
					index++;
				}
			}
		}

		// 0으로 치환
		for (int i = 0; i < row.size(); i++) {
			blockResult[row.get(i)][col.get(i)] = "0";
			blockResult[row.get(i)][col.get(i) + 1] = "0";
			blockResult[row.get(i) + 1][col.get(i)] = "0";
			blockResult[row.get(i) + 1][col.get(i) + 1] = "0";
		}

		int result = 0;
		for (int i = 0; i < blockResult.length; i++) {
			for (int j = 0; j < blockResult[i].length; j++) {
				if (blockResult[i][j].equals("0")) {
					result++;
				}
			}
		}

		// 0이면 공백으로 간주, swap
		String temp = null;
		for (int i = 0; i < blockResult.length - 1; i++) {
			for (int j = 0; j < blockResult[i].length; j++) {
				if (!"0".equals(blockResult[i][j]) && "0".equals(blockResult[i + 1][j])) {
					temp = blockResult[i][j];
					blockResult[i][j] = blockResult[i + 1][j];
					blockResult[i + 1][j] = temp;
				}
			}
		}
		return blockResult;
	}

	public static boolean isSameArray(String[][] a, String[][] b) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (!a[i][j].equals(b[i][j])) {
					return false;
				}
			}
		}

		return true;
	}

	public static int getAnswer(String[][] resultBlock) {
		int result = 0;
		for (int i = 0; i < resultBlock.length; i++) {
			for (int j = 0; j < resultBlock[i].length; j++) {
				if (resultBlock[i][j].equals("0")) {
					result++;
				}
			}
		}
		return result;
	}
}