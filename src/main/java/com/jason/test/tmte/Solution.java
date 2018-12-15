package com.jason.test.tmte;

public class Solution {

    public static void main(String[] args) {

        System.out.println(1_000_000_000);
        System.out.println(Integer.toBinaryString(-1));
        System.out.println((7 ^ -1) + 1);

        System.out.println(toNegativeBinaryString("111"));
        System.out.println(convertNumberBase(7, 2));
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


        System.out.println(Math.pow(2, 31));
        System.out.println(Integer.MAX_VALUE);
        // 10이상은 알파벳 대문자로 표현
        String numberStringArray = "0123456789ABCDEF";
        StringBuffer returnNumber = new StringBuffer();

        boolean isPositive = num >= 0;

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

    public static String toNegativeBinaryString(String binaryString) {

        int carry = 1;
        StringBuilder temp = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32 - binaryString.length(); i++) {
            temp.append('1');
        }
        for (int i = 0; i < binaryString.length(); i++) {
            temp.append(binaryString.charAt(i) == '0'? '1' : '0');
        }

        for (int i = temp.length() - 1; i > 0; i--) {
            int sum = (int) temp.charAt(i) + carry;
            carry = sum == 2? 1 : 0;
            sb.insert(0, sum % 2);
        }
        // 0000 0000 0000 0000 0000 0000 0000 0111  2진수
        // 1111 1111 1111 1111 1111 1111 1111 1000  1의 보수
        // 1111 1111 1111 1111 1111 1111 1111 1001  2의 보수

        return sb.toString();

    }


}
