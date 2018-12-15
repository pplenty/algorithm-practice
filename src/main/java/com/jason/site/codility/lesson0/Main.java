package com.jason.site.codility.lesson0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String NO = "NO";
        String input = br.readLine();
        String[] cardsString = input.split(" ");
        int[] cards = new int[cardsString.length];
        for (int i = 0; i < cardsString.length; i++) {
            cards[i] = Integer.parseInt(cardsString[i]);
        }
        
        Arrays.sort(cards);
        int sum = Integer.parseInt(br.readLine());
        boolean check = false;
    
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                
                for (int k = j + 1; k < cards.length; k++) {
                    if (cards[i] + cards[j] + cards[k] == sum) {
                        System.out.print(cards[i]);
                        System.out.print(" ");
                        System.out.print(cards[j]);
                        System.out.print(" ");
                        System.out.print(cards[k]);
                        System.out.println();
                        check = true;
                    }
                
                }
            }
        }
        
        if (!check) {
            System.out.println(NO);
        }
        Selling s = new Selling();
        
        s.setAreaCode("22");
        System.out.println(s.getAreaCode());
        
        
        
        
        
    }
    
    public static class Selling {
        
        String date;
        String itemCode;
    
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
    
        String areaCode;
        
    }
    
    
}