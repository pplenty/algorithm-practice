package com.jason.site.codility.lesson5;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-07-26
 * @description :
 */

public class CountDiv {
    
    public static void main(String[] args) {
        CountDiv countDiv = new CountDiv();
    
        // test case 1
        int count = countDiv.solution(6, 11, 2);
        System.out.println(count);
    
        int count2 = countDiv.solution(4, 11, 3);
        System.out.println(count2);
        int count3 = countDiv.solution(3, 11, 2);
        System.out.println(count3);
    
        
    }
    
    public int solution(int A, int B, int K) {
        
        if (A % K > 0) {
            return B / K - A / K;
        }
        
        return B / K - A / K + 1;
    }

    
}
