package com.jason.test.kko;

public class Test31 {


    public static void main(String[] args) {

        System.out.println(답을알려줘(2, 4, 2, 1));
        System.out.println(답을알려줘(16, 16, 2, 1));
        System.out.println(답을알려줘(16, 16, 2, 2));

    }

    public static String 답을알려줘(int 진수, int 횟수, int 인원, int 내순서) {

        StringBuffer answer = new StringBuffer();

        int 몇번 = 인원 * 횟수;
        StringBuffer buf = new StringBuffer();
        int j = 0;
        while(buf.length() <= 몇번) {
            buf.append(진법변환(j, 진수));
            j++;
        }

        String buffer = buf.substring(0, 몇번);

        for (int i = 내순서 - 1; i < buffer.length(); i += 인원) {
            answer.append(buffer.charAt(i));
        }

        System.out.println(buffer);
        return answer.toString();

    }

    public static String 진법변환(int value, int n){
        String numArray = "0123456789ABCDEF";
        StringBuffer result = new StringBuffer();
        if (value == 0){
            return "0";
        }
        while (value > 0) {
            result.insert(0, numArray.charAt(value % n));
            value = value / n;
        }
        return result.toString();
    }

}