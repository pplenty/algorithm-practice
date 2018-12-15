package com.jason.test.kko.test05;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) throws IOException {
		System.out.println(findSimilar(1234, 4321));
		System.out.println(findSimilar(1000, 0001));
	}

	/*
	 * Complete the findSimilar function below.
	 */
	static long findSimilar(long a, long b) {
		/*
		 * Write your code here.
		 */
		Map<Integer, Integer> mapA = new HashMap<>();
		Map<Integer, Integer> mapB = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			mapA.put(i, 0);
			mapB.put(i, 0);

		}

		int aCnt = 0;
		while (a > 0) {
			int mod = (int) (a % 10);
			mapA.put(mod, mapA.get(mod) + 1);
			a /= 10;
			aCnt++;
		}

		int bCnt = 0;
		while (b > 0) {
			int mod = (int) (b % 10);
			mapB.put(mod, mapB.get(mod) + 1);
			b /= 10;
			bCnt++;
		}

		System.out.println(mapA);
		System.out.println(mapB);

		System.out.println(mapA.equals(mapB));

		long result;

		if (mapA.equals(mapB)) {
			long aResult = fact(aCnt);
			for (Integer num : mapA.keySet()) {
				if (mapA.get(num) > 1) {
					aResult /= fact(mapA.get(num));
				}

			}
			result = aResult;

		} else {

			long bResult = fact(bCnt);
			for (Integer num : mapB.keySet()) {
				if (mapB.get(num) > 1) {
					bResult /= fact(mapB.get(num));
				}
			}
			result = bResult;

		}

		return result;
	}

	public static long fact(int n) {
		if (n <= 1)
			return n;
		else
			return fact(n - 1) * n;
	}

}
