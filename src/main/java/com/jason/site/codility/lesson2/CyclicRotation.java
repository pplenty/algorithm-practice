package com.jason.site.codility.lesson2;

import java.util.Arrays;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-08-10
 * @description :
 */

public class CyclicRotation {
    
    
    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();
    
        // test case 1
        int[] t1 = new int[]{4, 7, 2, 3};
        int[] solution = cyclicRotation.solution(t1, 3);
        System.out.println(Arrays.toString(solution));
        
        
    }
    
    public int[] solution(int[] A, int K) {
    
        int[] tmp = new int[A.length];
    
        for (int i = 0; i < A.length; i++) {
            tmp[(i + K) % A.length] = A[i];
        }
        
        return tmp;
    }
    
}
