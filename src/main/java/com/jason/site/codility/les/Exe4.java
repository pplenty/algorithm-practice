package com.jason.site.codility.les;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Exe4 {
    
    public static void main(String[] args) {
        
        Exe4 exe4 = new Exe4();
        
        // test case 1
        int count = exe4.solution("1", "2");
        System.out.println(count);
        
    }
    
    public int solution(String S, String T) {
        
        String[] sArray = S.split(":");
        String[] tArray = T.split(":");
        
        int hourS = Integer.parseInt(sArray[0]);
        int minS = Integer.parseInt(sArray[1]);
        int secS = Integer.parseInt(sArray[2]);
        
        int hourT = Integer.parseInt(tArray[0]);
        int minT = Integer.parseInt(tArray[1]);
        int secT = Integer.parseInt(tArray[2]);
        
        LocalTime timeMax = LocalTime.of(23, 33, 33);
        LocalTime timeS = LocalTime.of(hourS, minS, secS);
        LocalTime timeT = LocalTime.of(hourT, minT, secT);
        
        if (timeT.isAfter(timeMax)) {
            timeT = timeMax;
        }
        
        int count = 0;
        
        while (timeS.isBefore(timeT.plusSeconds(1L))) {
            
            Set<Character> numberSet = new HashSet<>();
            String hour = timeS.format(DateTimeFormatter.ofPattern("HH"));
            String min = timeS.format(DateTimeFormatter.ofPattern("mm"));
            String second = timeS.format(DateTimeFormatter.ofPattern("ss"));
            
            numberSet.add(hour.charAt(0));
            numberSet.add(hour.charAt(1));
            numberSet.add(min.charAt(0));
            numberSet.add(min.charAt(1));
            numberSet.add(second.charAt(0));
            numberSet.add(second.charAt(1));
            
            if (numberSet.size() <= 2) {
                count += 1;
            }
            
            timeS = timeS.plusSeconds(1L);
        }
        
        return count;
    }
    
}
