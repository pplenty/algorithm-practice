package com.jason.test.kko.test;

public class Solution4 {

    static int solve(String str) {
        String programmer = "programmer";

    	String head = programmer;

    	int i = 0;
    	// programmer
        for (; i < str.length(); i++) {
            int pIndex = head.indexOf(str.charAt(i));
            if (pIndex != -1) {
                head = head.substring(0, pIndex).concat(head.substring(pIndex + 1));
            }

            if (head.length() == 0) {
                i++;
                break;
            }
        }

    	String tail = programmer;

    	int j = str.length() - 1;
    	// programmer
        for (; j >= 0; j--) {
            int pIndex = tail.indexOf(str.charAt(j));
            if (pIndex != -1) {
                tail = tail.substring(0, pIndex).concat(tail.substring(pIndex + 1));
            }

            if (tail.length() == 0) {
                j--;
                break;
            }
        }

        System.out.println(head);
        System.out.println(i);
        System.out.println(j);


		return j - i + 1;
    }


    public static void main(String[] args) {
        System.out.println(solve("progxrammerrxproxgrammer"));
        System.out.println(solve("progxrammerrxproxgrammerprogxrammerrxproxgrammer"));
    }
}
