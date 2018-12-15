package com.jason.site.codility.lesson4;

import java.util.ArrayList;
import java.util.List;

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
        int count = permCheck.solution(test1);
        System.out.println("Answer : " + count);

    }

    public int solution(int[] A) {


        List<Integer> cache = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] > A.length) {
                return 0;
            } else {

                if (cache.indexOf(A[i]) != -1) {
                    return 0;
                }
                cache.add(A[i]);
            }


        }

        return 1;
    }
}
