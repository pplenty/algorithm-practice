package com.jason.site.leetcode.easy.jewelsAndStones;

/**
 *
 * 771. Jewels and Stones
 */
class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.numJewelsInStones("aA", "aAAbbbb"));
    }
    public int numJewelsInStones(String J, String S) {

        int count = 0;
        char[] jewels = J.toCharArray();
        char[] myStones = S.toCharArray();

        for (int i = 0; i < jewels.length; i++) {

            for (int j = 0; j < myStones.length; j++) {
                if (jewels[i] == myStones[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}