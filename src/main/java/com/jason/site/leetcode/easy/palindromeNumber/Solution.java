package com.jason.site.leetcode.easy.palindromeNumber;

import java.util.ArrayDeque;

/**
 * @author : Yusik
 * @version : 1.0
 * @date : 2019-01-08
 * @description :
 */
public class Solution {

    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.isPalindrome(121));
        System.out.println(sol.isPalindrome(-121));
        System.out.println(sol.isPalindrome(10));

    }

    public boolean isPalindrome(int x) {

        int divider = 10;
        if (x < 0) {
            return false;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        do {
            queue.add(x % divider);
            x = x / 10;
        } while (x > 0);

        while (queue.size() > 1) {
            if (queue.pollFirst() != queue.pollLast()) {
                return false;
            }
        }

        return true;
    }
}
