package com.jason.site.leetcode.easy.singleNumber;


import java.util.HashMap;
import java.util.Map;

class Solution2 {

    public static void main(String[] args) {

        // test case 1
        int answer = new Solution2().singleNumber(new int[]{2,2,3,2});
        System.out.println(answer);

        // test case 2
        int answer2 = new Solution2().singleNumber(new int[]{0,1,0,1,0,1,99});
        System.out.println(answer2);
    }

    public int singleNumber(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            nums[i] = nums[i-1] ^ nums[i];

            // 4 1 2 1 2


            // 1001

            // 0101
            // 0010
            // 0101
            // 0010

            // 0010 0101 1001
        }

        return nums[nums.length-1];
    }
}