package com.jason.site.codility.lesson6;

public class Triangle {

    public static void main(String[] args) {
        Triangle triangle = new Triangle();

        // test case 1
        int[] A1 = new int[]{10, 2, 5, 1, 8, 20};// 1, 2, 5, 8, 10, 20
        // 3, 4, 5, 6, 7,8 ,9
        int ans1 = triangle.solution(A1);
        System.out.println("Answer : " + ans1);

        int[] A2 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        int ans2 = triangle.solution(A2);
        System.out.println("Answer : " + ans2);

        int[] A3 = new int[]{10, 20, 5, 1};// 1, 5, 6, 20
        int ans3 = triangle.solution(A3);
        System.out.println("Answer : " + ans3);

    }

    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        sort(A, 0, A.length - 1);
        for (int i = 0; i < A.length - 2; i++) {

            if ((long) A[i] + (long) A[i + 1] > (long) A[i + 2]) {
                return 1;
            }
        }
        return 0;
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
