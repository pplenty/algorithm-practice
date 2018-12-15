package com.jason.site.codility.lesson0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main2 {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<Selling> parsedDataList = new ArrayList<>();
        ArrayList<String> dataList = new ArrayList<>();
        String input;
        while ((input = br.readLine()) != null) {
            dataList.add(input);
            
            if (input.equals("2018-08-08|10001|A05")) {
                break;
                
            }
        }
    
        System.out.println(dataList);
    
//        dataList.si
        dataList.forEach((line) -> {
            System.out.println(line);
            String[] tmp = line.split("\\|");
            System.out.println(Arrays.toString(tmp));
            
            Selling selling = new Selling();
            selling.setDate(tmp[0]);
            selling.setItemCode(tmp[1]);
            selling.setAreaCode(tmp[2]);
            
            parsedDataList.add(selling);
        });
        
        Map<String, Map<String, Integer>> result = new HashMap<>();
        parsedDataList.forEach((sell) -> {
            System.out.println(sell.getDate());
    
            String day = sell.getDate().substring(8);
            if (Integer.parseInt(day) > 1 && Integer.parseInt(day) < 10) {
    
                if (!result.containsKey(sell.getItemCode())) {
                    result.put(sell.getItemCode(), new HashMap<>());
                }
    
                Map<String, Integer> tmp = result.get(sell.getItemCode());
                
                if (!tmp.containsKey(sell.getAreaCode())) {
                    tmp.put(sell.getAreaCode(), 0);
                }
    
                tmp.put(sell.getAreaCode(), tmp.get(sell.getAreaCode()) + 1);
            }
        });
    
    
    
        System.out.println(result);
    
        //        String[] itemRank =
        
        ArrayList<Map<String, Integer>> rankList = new ArrayList<>();
    
        result.forEach((itemCode, areaCount)-> {
    
            System.out.print(itemCode + ":{N}=>");
            
            areaCount.forEach((areaCode, count) ->{
                    System.out.println(areaCode + ":" + count +",");
                    System.out.println(count);
            });
            System.out.println();
        });
        
    }
    
    public static class Selling {
        
        String date;
        String itemCode;
        String areaCode;
        
        public String getDate() {
            
            return date;
        }
        
        public void setDate(String date) {
            
            this.date = date;
        }
        
        public String getItemCode() {
            
            return itemCode;
        }
        
        public void setItemCode(String itemCode) {
            
            this.itemCode = itemCode;
        }
        
        public String getAreaCode() {
            
            return areaCode;
        }
        
        public void setAreaCode(String areaCode) {
            
            this.areaCode = areaCode;
        }
    
        @Override
        public String toString() {
        
            return "\n[ Selling ]\n{\n" +
                    "\n- date=" + date +
                    "\n- itemCode=" + itemCode +
                    "\n- areaCode=" + areaCode +
                    "\n}";
        }
    }
}