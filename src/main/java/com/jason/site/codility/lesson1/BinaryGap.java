package com.jason.site.codility.lesson1;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-08-09
 * @description :
 */

public class BinaryGap {
    
    
    public static void main(String[] args) {
        BinaryGap countDiv = new BinaryGap();
    
        // test case 1
        int gab = countDiv.solution(32);
        System.out.println(gab);
        int gab2 = countDiv.solution(1041);
        System.out.println(gab2);
        int gab3 = countDiv.solution(15);
        System.out.println(gab3);
    }
    
    public int solution(int N) {
        int maxGab = 0;
        int gab = -1;
        while (N != 0) {
            if (N % 2 == 1) {
                if (gab > 0 && gab > maxGab) {
                    maxGab = gab;
                }
                gab = 0;
            } else {
                if (gab > -1) {
                    gab++;
                }
            }
            N >>= 1;
        }
    
        return maxGab;
    }
    
}
