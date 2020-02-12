package com.jason.site.codility.lesson3;

public class FrogJmp {
    public static void main(String[] args) {
        FrogJmp frogJmp = new FrogJmp();
        // test case 1
        int solution = frogJmp.solution(10, 85, 30);
        System.out.println(solution);
        
    }

    public int solution(int X, int Y, int D) {
        int diff = Y - X;
        return diff % D == 0 ? diff / D : diff / D + 1;
    }
    
}
