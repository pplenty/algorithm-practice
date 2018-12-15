package com.jason.site.codility.lesson0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Exam03 {
    
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        
        List<String> memoArray = new ArrayList<>();
        while ((input = br.readLine()) != null) {
            if ("END".equals(input))
                break;
            memoArray.add(input);
        }
        
        Collections.sort(memoArray, (memo1, memo2) -> {
            
            String dateString1 = getDateString(memo1);
            String dateString2 = getDateString(memo2);
            
            Date date1 = getDate(dateString1);
            Date date2 = getDate(dateString2);
            
            int compare = date1.compareTo(date2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            
            return 0;
        });
        
        for (int i = 0; i < memoArray.size(); i++) {
            System.out.println(memoArray.get(i));
        }
        
    }
    
    public static Date getDate(String dateString) {
        
        SimpleDateFormat sdf;
        
        if (dateString.contains("-")) {
            if (dateString.charAt(4) != '-')
                dateString = "20" + dateString;
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            
        } else if (dateString.contains("/")) {
            if (dateString.charAt(4) != '/')
                dateString = "20" + dateString;
            sdf = new SimpleDateFormat("yyyy/MM/dd");
            
        } else {
            if (dateString.charAt(4) != '년')
                dateString = "20" + dateString;
            sdf = new SimpleDateFormat("yyyy년MM월dd일");
        }
        Date result = null;
        
        try {
            result = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static String getDateString(String memo) {
        
        int dateStartIndex = 0;
        int dateEndIndex = 0;
        
        for (int j = 0; j < memo.length(); j++) {
            char tempCh = memo.charAt(j);
            if ((int) tempCh >= 48 && (int) tempCh <= 57) {
                dateStartIndex = j;
                break;
            }
        }
        for (int j = dateStartIndex + 1; j < memo.length(); j++) {
            char tmpChar = memo.charAt(j);
            if ((int) tmpChar < 48 || (int) tmpChar > 57) {
                if (tmpChar != '년' && tmpChar != '월' && tmpChar != '일' && tmpChar != '-' && tmpChar != '/') {
                    dateEndIndex = j;
                    break;
                }
                
            }
        }
        
        String getDate = memo.substring(dateStartIndex, dateEndIndex);
        
        return getDate;
        
    }
    
}