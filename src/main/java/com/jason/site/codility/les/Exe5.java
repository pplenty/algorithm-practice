package com.jason.site.codility.les;

public class Exe5 {

    public static void main(String[] args) {

        Exe5 exe5 = new Exe5();

        // test case 1
        // WHETOABCDEFGHIJKJIHGFEDCBAZWETOHOIW
        String result = exe5.solution("0123456789", 0, 6);
        System.out.println(result);

    }

    public String solution(String s, int start, int end) {

        char[] chars = s.toCharArray();
        char[] revers = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {

            if (i >= start && i < end) {
                revers[i] = chars[start + end - 1 - i];
            } else {
                revers[i] = chars[i];
            }
        }

        return new String(revers);
    }

}
