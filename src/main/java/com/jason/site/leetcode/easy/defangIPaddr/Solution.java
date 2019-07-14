package com.jason.site.leetcode.easy.defangIPaddr;

class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}