package com.jason.datastructure.bit;

import java.util.Stack;

public class BitTest {

    public static void main(String[] args) {

        System.out.println("6 & 5 :" + (6 & 5));// 0110 & 0101
        System.out.println("6 | 5 :" + (6 | 5));// 0101
        System.out.println("6 ^ 5 :" + (6 ^ 5));
        System.out.println("~ 6   :" + (~6));

        //  1011 0010 = 178
        System.out.println("10110010 = 178");

        // 양수 shift일땐 차이가 없음(둘다 0으로 채우기 때문에)
        System.out.println(178 >> 2); // 44
        System.out.println(178 >>> 2); // 44

        System.out.println(-10 >> 2); // 00001010 11110110 >>  11111101 00000011 = -3
        System.out.println(-10 >>> 2);// 00001010 11110110 >>> 00111101 0011 1101 1111 1111 1111 1111 1111 1101 = 1073741821
        // java에서 int 는 32bit 이므로 2bit rignt shift 후 앞의 빈칸을 0으로 채운다
        System.out.println(decimalToBinaryString(1073741821));
        System.out.println("****************");


        //  1011 0010 = 178

    }

    public static String decimalToBinaryString(int decimal) {

        boolean isPositive = true;
        if (decimal < 0) {
            isPositive = false;
        }

        Stack stack = remainderPushToStack(Math.abs(decimal), null);

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static Stack remainderPushToStack(int decimal, Stack stack) {
        if (stack == null) {
            stack = new Stack();
        }

        int quotient = decimal / 2;
        int remainder = decimal % 2;

        stack.push(remainder);

        if (quotient == 1 || quotient == 0) {
            stack.push(quotient);
        } else {
            remainderPushToStack(quotient, stack);
        }

        return stack;

    }

}
