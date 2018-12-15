package com.jason.site.codility.lesson0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main3 {
    
    static final int SPACE = 32;
    static final int TAB = 9;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> dataList = new ArrayList<>();
        int count = Integer.parseInt(br.readLine());
        String input;
        int tmp = 0;
        while ((input = br.readLine()) != null) {
            dataList.add(input);
            tmp++; if(tmp == 2) break;
        }
    
    
        ArrayList<String> result = new ArrayList<>();
        
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        for (int i = 0; i < dataList.size(); i++) {
            for (int j = 0; i < dataList.get(i).length(); i++) {
                if ((int)dataList.get(i).charAt(j) == SPACE) {
                    cnt++;
                    sb.append(" ");
                } else if ((int)dataList.get(i).charAt(j) == TAB) {
                    for (int k = 0; k < count - cnt; k++) {
                        sb.append(" ");
                    }
                    cnt = 0;
                } else {
                    sb.append(dataList.get(i).charAt(j));
                }
                
                if (cnt >= 4) {
                    cnt = 0;
                }
            }
            result.add(sb.toString());
        }
    
        result.forEach((line)-> System.out.println(line));
        
        
        
//        dataList.forEach((idx, line)-> {
//            System.out.println(line);
//            for (int i = 0; i < count; i++) {
//                if ((int)line.charAt(i) == SPACE) {
//
//                    "".repl
//
//                }
//
//            }
//        });
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}