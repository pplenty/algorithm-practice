package com.jason.site.codility.lesson17;

import java.util.Arrays;

import static java.util.stream.Collectors.toList;

/**
 * @author : kohyusik
 * @version : 1.0
 * @description :
 */
public class NumberSolitaire {

    public static void main(String[] args) {
        NumberSolitaire numberSolitaire = new NumberSolitaire();

        // test case 1
        int[] A1 = new int[]{1, -2, 0, 9, -1, -2, -3};
        int ans1 = numberSolitaire.solution(A1);
        System.out.println("Answer : " + ans1);

        int[] A2 = new int[] {-1, -1, -1, -1, 1, -1, -1, -1, -1};
        int ans2 = numberSolitaire.solution(A2);
        System.out.println("Answer : " + ans2);

    }

    public int solution(int[] A) {

        int[] result = new int[A.length + 6];
        Arrays.fill(result, Integer.MIN_VALUE);
        result[6] = A[0];

        for (int i = 7; i < result.length; i++) {
            result[i] = A[i - 6] + Math.max(Math.max(Math.max(Math.max(Math.max(result[i - 1], result[i - 2]), result[i - 3]), result[i-4]), result[i-5]), result[i-6]);
        }

        System.out.println(Arrays.stream(result).boxed().collect(toList()));

        return result[result.length - 1];

    }

}
