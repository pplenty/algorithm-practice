package com.jason.site.codility.lesson7;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {

        Brackets brackets = new Brackets();

        // test case 1
        String A1 = "{[()()]}";
        int ans1 = brackets.solution(A1);
        System.out.println("Answer : " + ans1);

        // test case 2
        String A2 = "+ )( + ()";
        int ans2 = brackets.solution(A2);
        System.out.println("Answer : " + ans2);

    }

    public int solution(String S) {

        List<Character> startBrackets = Arrays.asList('{', '[', '(');
        List<Character> endBrackets = Arrays.asList('}', ']', ')');

        Stack<Character> stack = new Stack<>();
        final char[] chars = S.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (startBrackets.contains(chars[i])) {
                stack.push(chars[i]);
            } else if (endBrackets.contains(chars[i])) {
                if (stack.isEmpty()) {
                    return 0;
                }
                final Character pop = stack.pop();
                if (!pop.equals(startBrackets.get(endBrackets.indexOf(chars[i])))) {
                    return 0;
                }


            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
