package com.jason.site.leetcode.medium.addTwoNumbers;

public class ListNode {
    
    int      val;
    ListNode next;
    
    ListNode(int x) {
        
        val = x;
    }
    
    @Override
    public String toString() {
        
        StringBuffer sb = new StringBuffer();
        
        ListNode p = this;
    
        while (p != null) {
            sb.append(p.val);
            p = p.next;
        }
        return sb.toString();
    }
}