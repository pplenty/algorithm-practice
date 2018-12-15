package com.jason.test.kko.test03;
import java.io.*;

public class Solution {

	public static void main(String[] args) {

		String filename = "hosts_access_log_01.txt";

		String outputFileName = filename.substring(filename.lastIndexOf("_") + 1, filename.lastIndexOf("."));
		outputFileName = "output_access_log_" + outputFileName + ".txt";
		System.out.println(outputFileName);

		long result = 0;
		int count = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String s;

			while ((s = in.readLine()) != null) {
				System.out.println(s);
				int last = s.lastIndexOf(" ");
				long bytesLog = Long.parseLong(s.substring(last + 1));

				if (bytesLog > 5000) {
					count++;
					result += bytesLog;
				}
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(outputFileName));
			out.write(String.valueOf(count));
			out.newLine();
			out.write(String.valueOf(result));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
