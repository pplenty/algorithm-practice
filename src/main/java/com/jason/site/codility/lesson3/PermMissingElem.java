package com.jason.site.codility.lesson3;

import java.util.Arrays;

/**
 * @author : Yusik
 * @version : 1.0
 * @date : 2018-10-11
 * @description :
 */
public class PermMissingElem {
    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();
        
        // test case 1
        int[] t1 = new int[]{2, 3, 1, 5, 6, 7, 8, 9, 10, 14, 12, 11, 13};
        int solution = permMissingElem.solution(t1);
        System.out.println(solution);
        
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
    
        int result = 1;
        Arrays.sort(A);
        
        if (A.length < 1 ) {
            result = (A.length == 0 || A[0] == 2)? 1 : 2;
        } else if (A[A.length - 1] == A.length) {
            result = A[A.length - 1] + 1;
        } else {
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i + 1] - A[i] > 1) {
                    result = A[i] + 1;
                    break;
                }
            }
        }
        
        return result;
    }
    
}
