package com.jason.site.leetcode.easy.defangingAnIPAddress;

/**
 * Created by yusik on 2019/12/07.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String address1 = "1.1.1.1";
        String answer = solution.defangIPaddr(address1);
        System.out.println(answer);

        String address2 = "255.100.50.0";
        String answer2 = solution.defangIPaddr(address2);
        System.out.println(answer2);
    }

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
