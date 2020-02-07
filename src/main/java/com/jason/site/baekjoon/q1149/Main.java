package com.jason.site.baekjoon.q1149;

import java.util.Scanner;

/**
 * input sample
 * 3
 * 26 40 83
 * 49 60 57
 * 13 89 99
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][3];
        int[][] result = new int[n][3];

        for (int i = 0; i < array.length; i++) {
            array[i][0] = scanner.nextInt();
            array[i][1] = scanner.nextInt();
            array[i][2] = scanner.nextInt();
        }

        result[0] = array[0];

        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = Math.min(array[i][j] + result[i - 1][(j + 1) % 3], array[i][j] + result[i - 1][(j + 2) % 3]);
            }
        }
        System.out.println(min(result[n - 1]));

    }

    public static int min(int[] rgb) {
        int min = rgb[0];
        if (min > rgb[1]) min = rgb[1];
        if (min > rgb[2]) min = rgb[2];
        return min;
    }
}