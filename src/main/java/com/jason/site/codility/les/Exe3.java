package com.jason.site.codility.les;

import java.time.LocalTime;
import java.util.HashMap;

public class Exe3 {
    
    public static void main(String[] args) {
        
        Exe3 exe3 = new Exe3();
        
        // test case 1
        String result = exe3.solution(4, 1);
        System.out.println(result);
        String result2 = exe3.solution(1, 4);
        System.out.println(result2);
        String result3 = exe3.solution(5, 3);
        System.out.println(result3);
    
        System.out.println(LocalTime.of(13, 11, 11));
        
    }
    
    public String solution(int A, int B) {
        
        StringBuffer sb = new StringBuffer();
        
        int COUNT_MAX = 2;
        String first = "a";
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", A);
        map.put("b", B);
        int count = 0;
        
        if (A < B) {
            first = "b";
        }
        
        while (map.get("a") > 0 || map.get("b") > 0) {
            
            if (count >= COUNT_MAX || map.get(first) == 0) {
                first = swapString(first);
                count = 0;
            }
            
            if ("a".equals(first) && map.get("a") > 0 || "b".equals(first) && map.get("b") > 0) {
                
                sb.append(first);
                count += 1;
                
                if ("a".equals(first)) {
                    map.put("a", map.get("a") - 1);
                } else {
                    map.put("b", map.get("b") - 1);
                }
            }
            
        }
        
        return sb.toString();
    }
    
    public String swapString(String s) {
        
        if ("a".equals(s)) {
            return "b";
        } else {
            return "a";
        }
    }
    
}
