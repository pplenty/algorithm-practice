package com.jason.site.codility.lesson2;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-08-10
 * @description :
 */

public class OddOccurrencesInArray {
    
    public static void main(String[] args) {
        
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        
        // test case 1
        int[] t1 = new int[] { 9, 3, 9, 3, 9, 7, 9, 7, 11};
        int solution = oddOccurrencesInArray.solution(t1);
        System.out.println(solution);
        
    }
    
    public int solution(int[] A) {
    
        sort(A, 0, A.length - 1);
        int result = A[A.length - 1];
        
        for (int i = 0; i < A.length - 1; i += 2) {
            if (A[i] != A[i + 1]) {
                result = A[i];
                break;
            }
        }
        return result;
    }
    
    public static void sort(int[] data, int l, int r) {
        
        int left = l;
        int right = r;
        int pivot = data[(l + r) / 2];
        
        do {
            while (data[left] < pivot)
                left++;
            while (data[right] > pivot)
                right--;
            if (left <= right) {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        } while (left <= right);
        
        if (l < right)
            sort(data, l, right);
        if (r > left)
            sort(data, left, r);
    }
    
}
