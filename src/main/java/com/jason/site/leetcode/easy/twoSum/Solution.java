package com.jason.site.leetcode.easy.twoSum;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void main(String[] args) {

        // test case 1
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;

        int[] answer = new Solution().twoSum(nums, target);
        System.out.println(Arrays.toString(answer));
    }
    
    public int[] twoSum(int[] nums, int target) {
    
        int[] answer = new int[2];
    
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }
}