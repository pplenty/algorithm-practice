package com.jason.site.codility.les;

import java.util.HashMap;
import java.util.Map;

public class Exe2 {
    
    public static void main(String[] args) {
        
        Exe2 exe2 = new Exe2();
        
        // test case 1
        int reportCount = exe2.solution(new int[] { 3, 4, 3, 0, 2, 2, 3, 0, 0 });
        System.out.println(reportCount);
        int reportCount2 = exe2.solution(new int[] { 4, 2, 0 });
        System.out.println(reportCount2);
        int reportCount3 = exe2.solution(new int[] { 4, 4, 3, 3, 1, 0 });
        System.out.println(reportCount3);
    }
    
    public int solution(int[] ranks) {
        
        int sum = 0;
        
        Map<Integer, Integer> countSum = new HashMap<>();
        
        for (int i = 0; i < ranks.length; i++) {
            if (countSum.containsKey(ranks[i])) {
                countSum.put(ranks[i], countSum.get(ranks[i]) + 1);
            } else {
                countSum.put(ranks[i], 1);
            }
        }
        
        int prevRank = -1;
        
        for (Integer rank : countSum.keySet()) {
            
            if (prevRank != -1) {
                if (rank - prevRank == 1) {
                    sum = sum + countSum.get(prevRank);
                }
            }
            prevRank = rank;
        }
        
        return sum;
    }
    
}
