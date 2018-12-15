package com.jason.test.kko.test02;

import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {

		int[] input = { 4, 6, 12, 8 };
		int[] input2 = { 1, 3, 4 };

		hackerCards(input2, 7);
		hackerCards(input, 14);

	}

	static int[] hackerCards(int[] collection, int d) {

		ArrayList<Integer> resultList = new ArrayList<>();

		sort(collection, 0, collection.length - 1);

		int idx = 0;
		for (int i = 1; i <= d; i++) {

			if (idx >= collection.length || i < collection[idx]) {
				if (d >= i) {
					resultList.add(i);
					d -= i;
				} else if (d < i) {
					break;
				}
			} else if (i == collection[idx]) {
				idx++;
			}
		}

		int[] answer = new int[resultList.size()];

		int index = 0;
		for (int i : resultList) {
			answer[index] = i;
			index++;
		}

		return answer;
	}

	public static void sort(int[] data, int l, int r) {
		int left = l;
		int right = r;
		int pivot = data[(l + r) / 2];
		do {
			while (data[left] < pivot)
				left++;
			while (data[right] > pivot)
				right--;
			if (left <= right) {
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				left++;
				right--;
			}
		} while (left <= right);
		if (l < right) {
			sort(data, l, right);
		}
			
		if (r > left) {
			sort(data, left, r);
		}
	}
}
