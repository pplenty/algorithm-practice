package com.jason.site.leetcode.easy.countBinarySubstrings;

/**
 * 696. Count Binary Substrings
 *
 * @author : yusik
 * @date : 07/14/2018
 */
public class Solution {

    public static void main(String[] args) {
        int answer = new Solution().countBinarySubstrings("00110011");
        System.out.println(answer);
        int answer2 = new Solution().countBinarySubstrings("10101");
        System.out.println(answer2);
        int answer3 = new Solution().countBinarySubstrings("00110");
        System.out.println(answer3);
        int answer4 = new Solution().countBinarySubstrings("001100");
        System.out.println(answer4);

    }


    // todo 07-14
    public int countBinarySubstrings(String s) {
        int sum = 0;

        char[] input = s.toCharArray();

        int cache = -1;
        int direction = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i - 1] == input[i]) {
                if (direction == -1) sum += 1;
            } else {
                sum += 1;
                direction *= -1;

                cache = i;
            }
        }

        return sum;
    }
}
