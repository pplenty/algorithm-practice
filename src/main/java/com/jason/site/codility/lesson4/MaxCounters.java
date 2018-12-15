package com.jason.site.codility.lesson4;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-07-26
 * @description :
 */

public class MaxCounters {
    
    public static void main(String[] args) {
        MaxCounters maxCounters = new MaxCounters();
    
        // test case 1
        int n1 = 5;
        int[] input1 = new int[] {3, 4, 4, 6, 1, 4, 4};
//        int n1 = 5;
//        int[] input1 = new int[] {1, 6, 6, 6, 6, 6, 6};
//        int n1 = 1;
//        int[] input1 = new int[] {2, 1, 1};
        System.out.println("N : " + n1);
        System.out.print("arr : ");
        printArray(input1);
        int[] counter = maxCounters.solution(n1, input1);
    
        printArray(counter);
        
    }
    
    public int[] solution(int N, int[] A) {
        int max = 0;
        int adder = 0;
        int[] counter = new int[N];
        
        for (int i = 0, l1 = A.length; i < l1; i++) {
            int n = A[i];
    
            if (n == N + 1) {
                
                adder += max;
                max = 0;
                counter = new int[N];
                
            } else {
                
                counter[n - 1] += 1;
                
                // set max
                if (counter[n - 1] > max) {
                    max = counter[n - 1];
                }
            }
        }
    
        for (int j = 0, l2 = counter.length; j < l2; j++) {
            counter[j] += adder;
        }
        
        return counter;
    }
    
    public static void printArray(int[] array) {
        System.out.print("{ ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }
    
    
}
