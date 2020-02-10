package com.jason.site.codility.lesson6;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

    public static void main(String[] args) {
        Distinct distinct = new Distinct();

        // test case 1
        int[] A1 = new int[]{2, 1, 1, 2, 3, 1};
        int ans1 = distinct.solution(A1);
        System.out.println("Answer : " + ans1);
    
    }

    public int solution(int[] A) {

        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            numbers.add(A[i]);
        }
        
        return numbers.size();
    }

}
