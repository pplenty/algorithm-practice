package com.jason.test.kko.test06;

public class Solution3 {

	public static void main(String[] args) {
		System.out.println(solution(1, 100, 12,5, 53, 33));
		
	}
	
	public static int solution(int Gold1, int Silver1, int Bronze1, int Gold2, int Silver2, int Bronze2) {
		
		int result = 0;
		
		System.out.println(exchangeCoin(0, Gold1, Gold2, Silver2 - Silver1));
		System.out.println(exchangeCoin(Gold2 - Gold1, Silver1, Silver2, Bronze2 -Bronze1));
		
		
        return 0;
    }
	
	public static int exchangeCoin(int upperCoin, int currentCoin, int needCoin, int lowerCoin) {

		int exchangeCout = 0;

		int coin = needCoin - currentCoin;
		
		if (coin > 0) {
			
			while (upperCoin > 0) {
				coin -= upperCoin * 9;
				upperCoin--;
				exchangeCout++;
				
				if (coin <= 0) {
					break;
				}
			}
		
			if (coin > 0) {
				while (lowerCoin > 0) {
					coin -= lowerCoin;
					lowerCoin -= 11;
					exchangeCout++;
					
					if (coin <= 0) {
						break;
					}
				}
			}

		} 
		
		return exchangeCout;
	}

}
