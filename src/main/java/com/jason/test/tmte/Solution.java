package com.jason.test.tmte;

public class Solution {

    public static void main(String[] args) {

        System.out.println(convertNumberBase(-2, 1));
        System.out.println(countBits(-100));// 1011
        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.toBinaryString(-7));
        System.out.println(Integer.toHexString(7));
        System.out.println(Integer.toHexString(-7));

        //"11111111111111111111111111111111";
        //"00000000000000000000000000000111";
        //"11111111111111111111111111111001";
    }

    public static String convertNumberBase(int num, int n) {
        // 10이상은 알파벳 대문자로 표현
        String numberStringArray = "0123456789ABCDEF";
        StringBuffer returnNumber = new StringBuffer();
        while (num > 0) {
            // n으로 나눈 나머지에 해당하는 문자를 역순으로(맨 앞으로) 조립 한다
            returnNumber.insert(0, numberStringArray.charAt(num % n));
            num /= n;
        }
        return returnNumber.toString();
    }

    public static int countBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num % 2;
            num /= 2;
        }
        return count;
    }


}
