package com.jason.site.leetcode.medium.longestSubstring;

/**
 * @author : yusik
 * @date : 02/12/2018
 */
public class Solution {

    public static void main(String[] args) {

        int answer = new Solution().lengthOfLongestSubstring("a");
        System.out.println(answer);

    }

    public int lengthOfLongestSubstring(String s) {

        int lengthOfLongest = 0;
        StringBuffer tmp;
        char[] array = s.toCharArray();

        if (s.length() == 1) return 1;
        for (int i = 0; i < array.length - 1; i++) {

            tmp = new StringBuffer();
            tmp.append(array[i]);

            for (int j = i + 1; j < array.length; j++) {

                if (tmp.indexOf(String.valueOf(array[j])) < 0) {
                    tmp.append(array[j]);
                } else {

                    if (tmp.toString().length() > lengthOfLongest) {
                        lengthOfLongest = tmp.toString().length();
                    }
                    break;
                }

                if (tmp.toString().length() > lengthOfLongest) {
                    lengthOfLongest = tmp.toString().length();
                }


            }

        }

        return lengthOfLongest;
    }
}
