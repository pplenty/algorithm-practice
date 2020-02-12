package com.jason.site.codility.lesson4;

import java.util.Arrays;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-08-04
 * @description :
 */
public class PermCheck {

    public static void main(String[] args) {
        PermCheck permCheck = new PermCheck();

        // test case 1
        int[] test1 = new int[]{4, 1, 2, 3};
        int result1 = permCheck.solution(test1);
        System.out.println("Answer : " + result1);

        // test case 2
        int[] test2 = new int[]{4, 1, 3};
        int result2 = permCheck.solution(test2);
        System.out.println("Answer : " + result2);

        // test case 3
        int[] test3 = new int[]{Integer.MAX_VALUE};
        int result3 = permCheck.solution(test3);
        System.out.println("Answer : " + result3);

    }

    public int solution(int[] A) {

        Arrays.sort(A);

        if (A[0] != 1 || A[A.length - 1] != A.length) {
            return 0;
        }

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i + 1] - A[i] != 1) {
                return 0;
            }
        }

        return 1;
    }
}
