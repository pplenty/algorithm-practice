package com.jason.site.codility.lesson7;

/**
 * @author : kohyusik
 * @version : 1.0
 * @description :
 */
public class NumberOfDiscIntersections {

    public static void main(String[] args) {
        NumberOfDiscIntersections numberOfDiscIntersections = new NumberOfDiscIntersections();

        // test case 1
//        int[] A1 = new int[] {1, 5, 2, 1, 4, 0};
//        int ans1 = numberOfDiscIntersections.solution(A1);
//        System.out.println("Answer : " + ans1);
        
        int[] A2 = new int[] {1, 2147483647, 0};
        int ans2 = numberOfDiscIntersections.solution(A2);
        System.out.println("Answer : " + ans2);
    
    }

    public int solution(int[] A) {
    
        int interCount = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = i + 1; j < A.length; j++) {
    
                // (i - A[i], i + A[i])
                // (j - A[j], j + A[j])
                
                if ((long)i + A[i] >= j) {
                    interCount++;
                } else {
                    if ((long)i + A[i] >= (long)j - A[j]) {
                        interCount++;
                    }
                }
                
                if (interCount > 10000000) return -1;
            }
        }
        
        return interCount;
    }

}
