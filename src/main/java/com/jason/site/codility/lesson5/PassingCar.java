package com.jason.site.codility.lesson5;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-08-04
 * @description :
 */
public class PassingCar {

    public static void main(String[] args) {
        PassingCar passingCar = new PassingCar();

        // test case 1
        int[] test1 = new int[] {0, 1, 0, 1, 1};
        int count = passingCar.solution(test1);
        System.out.println("Answer : " + count);

        int[] test2 = new int[] {0, 0, 0, 1, 1};
        int count2 = passingCar.solution(test2);
        System.out.println("Answer : " + count2);

        int[] test3 = new int[] {0, 1, 1, 0, 1, 0, 1};
        int count3 = passingCar.solution(test3);
        System.out.println("Answer : " + count3);

    }

    public int solution(int[] A) {
        // 0 1 0 1 1

        // 0 1 2 3 4
        // 0   0
        //   1   1 1
        // 5

        // 0 1 2 3 4
        // 0 0 0
        //       1 1
        // 6

        // 0 1 2 3 4 5 6
        // 0     0   0
        //   1 1   1   1
        // 7

        // 0 1 1 0 1 0 1
        //
        int countEast = 0;
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                countEast += 1;
            } else {
                result += countEast;
            }


            if (result > 1000000000) {
                return -1;
            }
        }

        return result;

    }

}
