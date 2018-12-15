package com.jason.test.kko.test06;

import java.util.Arrays;

public class Solution2 {

	final static String CHEATER = "CHEATER";

	public static void main(String[] args) {

		System.out.println(getDinner("ABCD", "AB", "C"));
		System.out.println(getDinner("ABEDCS", "", ""));
		System.out.println(getDinner("EDSMB", "MSD", "A"));
		System.out.println(getDinner("", "", ""));

	}

	static String getDinner(String diet, String breakfast, String lunch) {

		String dinner = new String();

		// 아침 메뉴 제거
		dinner = eating(diet, breakfast);

		// 점심 메뉴 제거
		dinner = eating(dinner, lunch);

		if (dinner.equals(CHEATER)) {
			return dinner;
		}
		
		return sortString(dinner);
	}

	static String eating(String menu, String ate) {

		int maxCount = menu.length();

		for (int i = 0; i < ate.length(); i++) {

			String food = String.valueOf(ate.charAt(i));
			if (menu.contains(food)) {
				maxCount--;
				menu = menu.replace(food, "");
			} else {
				return CHEATER;
			}

			if (maxCount < 0) {
				return CHEATER;
			}
		}

		return menu;
	}

	static String sortString(String dinner) {
		char[] dinnerArray = dinner.toCharArray();
		Arrays.sort(dinnerArray);
		return new String(dinnerArray);
	}

}
