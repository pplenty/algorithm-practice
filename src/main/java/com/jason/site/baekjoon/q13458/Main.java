package com.jason.site.baekjoon.q13458;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            new Main().solve();
    }

    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        long result = 0;

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int general = sc.nextInt();
        int acting = sc.nextInt();

        for (int i = 0; i < n; i++) {
            result++;
            array[i] -= general;

            if (array[i] > 0) {
                result += Math.ceil(1.0 * array[i] / acting);
            }

        }
        System.out.println(result);
    }
}