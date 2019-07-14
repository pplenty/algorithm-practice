package com.jason.site.leetcode.medium.maxIncreaseToKeepCitySkyline;

/**
 * 807. Max Increase to Keep City Skyline
 *
 * @author : yusik
 * @date : 07/14/2018
 */
public class Solution {

    public static void main(String[] args) {

        int[][] input = new int[][]{
                {3,0,8,4},
                {2,4,5,7},
                {9,2,6,3},
                {0,3,1,0}};
        int answer = new Solution().maxIncreaseKeepingSkyline(input);
        System.out.println(answer);

    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int sum = 0;
        int[][] gridNew = new int[grid.length][grid[0].length];

        int[] skylineViewTopBottom = new int[grid[0].length];
        int[] skylineViewLeftRight = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > skylineViewLeftRight[i]) {
                    skylineViewLeftRight[i] = grid[i][j];
                }

                if (grid[i][j] > skylineViewTopBottom[j]) {
                    skylineViewTopBottom[j] = grid[i][j];
                }
            }
        }

//        printArray1(skylineViewTopBottom);
//        printArray1(skylineViewLeftRight);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                gridNew[i][j] = Math.min(skylineViewLeftRight[i], skylineViewTopBottom[j]);
                sum += gridNew[i][j] - grid[i][j];
            }
        }

//        printArray2(gridNew);
        return sum;
    }

    public void printArray2(int[][] array) {

        for (int i = 0; i < array.length; i++) {
            printArray1(array[i]);
        }
    }

    public void printArray1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }
}
