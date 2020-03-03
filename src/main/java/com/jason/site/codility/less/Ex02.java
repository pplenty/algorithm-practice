package com.jason.site.codility.less;

import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class Ex02 {

    public static void main(String[] args) {
        Ex02 ex2 = new Ex02();

        // test case 1
        int solution = ex2.solution("acbcbba");
        System.out.println(solution);

        // test case 1
        int solution2 = ex2.solution("abcdefghijklmnopqrstuvwxyz");
        System.out.println(solution2);

    }

    public int solution(String S) {
        return (int) S.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .count();
    }

}
