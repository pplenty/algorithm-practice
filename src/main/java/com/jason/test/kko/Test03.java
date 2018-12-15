package com.jason.test.kko;

import java.util.ArrayDeque;
import java.util.Queue;

public class Test03 {

    public static void main(String[] args) {

        String[] testCase1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(getSpentTime(3, testCase1));

        String[] testCase2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        System.out.println(getSpentTime(3, testCase2));

        String[] testCase3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        System.out.println(getSpentTime(2, testCase3));

        String[] testCase4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        System.out.println(getSpentTime(5, testCase4));

        String[] testCase5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println(getSpentTime(2, testCase5));

        String[] testCase6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(getSpentTime(0, testCase6));




    }
    public static int getSpentTime(int cacheSize, String[] cities) {
        int spentTime = 0;

        Queue<String> queue = new ArrayDeque<>();


        for (String city : cities) {
            city = city.toUpperCase();
            int searchTime = 1;

            if (!queue.contains(city)){
                searchTime = 5;
                if (queue.size() == cacheSize) {
                    queue.poll();
                }
                if (cacheSize != 0) {
                    queue.add(city);
                }
            }
            spentTime += searchTime;
        }
        return spentTime;
    }
}
