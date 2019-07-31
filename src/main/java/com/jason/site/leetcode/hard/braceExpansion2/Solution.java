package com.jason.site.leetcode.hard.braceExpansion2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {

        // test case 1
        List<String> answer = new Solution().braceExpansionII("{a,b}{c,{d,e}}");
//        System.out.println(answer);

        // test case 2
        List<String> answer2 = new Solution().braceExpansionII("{{a,z},a{b,c},{ab,z}}");
//        System.out.println(answer2);
    }

    //    Constraints:
//    1. 1 <= expression.length <= 50
//    2. expression[i] consists of '{', '}', ','or lowercase English letters.
//    3. The given expression represents a set of words based on the grammar given in the description.
    public List<String> braceExpansionII(String expression) {

        Stack<String> braceStack = new Stack<>();
        char[] expressionUnit = expression.toCharArray();

        List<List<String>> buffer = new ArrayList<>();
        List<String> temp = null;
        StringBuffer sb = null;

        for (int i = 0; i < expressionUnit.length; i++) {

            if (expressionUnit[i] == '}') {
                System.out.println(popContentFromBrace(braceStack));
            } else {
                braceStack.push(String.valueOf(expressionUnit[i]));
            }


        }

        System.out.println(braceStack);

        return null;
    }

    public String popContentFromBrace(Stack<String> braceStack) {

        StringBuffer sb = new StringBuffer();

        String content = braceStack.pop();
        while (!"{".equals(content)) {
            sb.append(content);
            content = braceStack.pop();
        }
        return sb.toString();
    }


    public class Brace {
        Brace innerBrace;

        public String getContent() {
            return "";
        }
    }
}