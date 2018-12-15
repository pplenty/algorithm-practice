package com.jason.site.leetcode.easy.reverseInteger;


import java.util.Stack;

class Solution {

    public static void main(String[] args) {

        // test case 1
        int answer = new Solution().reverse(123);
        System.out.println(answer);

        // test case 2
        int answer2 = new Solution().reverse(1534236469);
        System.out.println(answer2);
    }

    public int reverse(int x) {

        Stack<Integer> stack = new Stack<>();
        int sign = 1;

        if (x < 0) {
            sign = -1;
        }

        int absX = Math.abs(x);

        while (absX > 0) {
            stack.push(absX % 10);
            absX /= 10;
        }

        long result = 0L;
        long i = 1;
        while (!stack.isEmpty()) {

            result += stack.pop() * i;
            i *= 10;
        }

        result = sign * result;

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;

    }
}