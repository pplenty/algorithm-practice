package com.jason.test.kko.test06;

import java.io.IOException;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		System.out.println(getDistance("abcdef", "fedcba", "fed"));
		
		System.out.println(getDistance("aaaaa", "bbbbb", "a"));
		
		System.out.println(getDistance("aaAaB", "BbaAa", "ab"));
	}

	static int getDistance(String a, String b, String letterSet) {
		
		int result = 0;
		
		for (int i = 0; i < letterSet.length(); i++) {
			
			
			result += (int) Math.pow(getCountLetter(a, letterSet.charAt(i)) - getCountLetter(b, letterSet.charAt(i)), 2);
			
		}
		
		
		return result;
	}
	
	static int getCountLetter(String a, char letter) {
		int count = 0;
		a = a.toLowerCase();
		for (int i = 0; i < a.length(); i++) {
			if (letter == a.charAt(i)) {
				count++;
			}
		}
		
		return count;
	}

}
