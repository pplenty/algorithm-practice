package com.jason.site.leetcode.easy.jewelsAndStones;

/**
 *
 * 771. Jewels and Stones
 */
class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numJewelsInStones("aA", "aAAbbbb"));

        System.out.println(sol.numJewelsInStones("z", "ZZ"));
    }
    public int numJewelsInStones(String J, String S) {

        int count = 0;
        char[] jewels = J.toCharArray();
        char[] myStones = S.toCharArray();

        for (char jewel : jewels) {
            for (char myStone : myStones) {
                if (jewel == myStone) {
                    count++;
                }
            }
        }
        return count;
    }
}