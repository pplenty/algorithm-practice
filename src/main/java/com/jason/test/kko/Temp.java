package com.jason.test.kko;

public class Temp {

	public static void main(String[] args) {
		System.out.println(decode("23511011501782351112179911801562340161171141148"));
		System.out.println(decode("51156511"));
	}

	/*
	 * Complete the decode function below.
	 */
	public static String decode(String encoded) {
		/*
		 * Write your code here.
		 */

		StringBuffer sb = new StringBuffer();
		char[] input = encoded.toCharArray();
		char[] output = new char[input.length];

		String output1;
		for (int i = 0; i < input.length; i++) {
			output[output.length - i - 1] = input[i];
		}

		System.out.println(output);

		for (int i = 0; i < output.length - 1; i += 2) {

			int temp = Integer.parseInt(String.valueOf(output[i]) + String.valueOf(output[i + 1]));

			if (temp >= 10 && temp <= 12) {
				temp = temp * 10 + Integer.parseInt(String.valueOf(output[i + 2]));
				i += 1;
			}
			System.out.println(temp);

			sb.append((char) temp);

		}

		return sb.toString();

	}
}