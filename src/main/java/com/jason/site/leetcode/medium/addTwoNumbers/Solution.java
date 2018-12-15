package com.jason.site.leetcode.medium.addTwoNumbers;
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
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
    
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
    
        ListNode answer = new Solution().addTwoNumbers(l1, l2);
        System.out.println(answer);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
        ListNode head = null;
        ListNode p = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        
        do {
            
            // sum
            int sum = carry;
            carry = 0; // reset carry
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            
            // carry
            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            }
            
            if (head == null) {
                p = new ListNode(sum);
                head = p; // set head
            } else {
                p.next = new ListNode(sum);
                p = p.next;
            }
            
        
        } while (p1 != null || p2 != null || carry > 0);
        
        return head;
    }
}