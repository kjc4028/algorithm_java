package algorithm_java;

import java.util.Arrays;
import java.util.StringTokenizer;

/*
[문제]
 달이가 게에 와서 여러가지 과자를 사려고 합니다.
 그런데 해달이는 가게에 지폐 1장만 들고 왔고 가게는 돈을 거슬러 주어야 하지만 동전 밖에 없습니다. 
 해달이가 최소의 동전 개수로 돈을 거슬러 받기 위해서는 몇개의 동전을 거슬러 받아야 하는지 프로그래밍 하세요
*/
public class ChangeMoney {

	static int totalPrice = 3200; //구매금액
	static int poketMoney = 5000; //보유금액
	
	
	static String coinCase = "10 50 500 1000"; //동전 종류
	
	
	
	public static void main(String[] args) {
		
		StringTokenizer st = new StringTokenizer(coinCase);
		
		int[] coin = new int[st.countTokens()];
		int coinSetIdx = 0;
		
		//동전 종류 배열에 셋팅
		while(st.hasMoreTokens()){
			coin[coinSetIdx] = Integer.parseInt(st.nextToken());
			coinSetIdx++;
		}
		
		System.out.println("동전 동류 : " + Arrays.toString(coin));
		
		int[] rtPrice = new int[poketMoney - totalPrice+1];
		
		for(int i = 1; i < rtPrice.length; i++){
				rtPrice[i] = -1;
				for(int j = 0; j < coin.length; j++){
					if(coin[j] <= i){
						if(rtPrice[i-coin[j]] < 0) continue;
						if(rtPrice[i]<0){
							rtPrice[i] = rtPrice[i-coin[j]] + 1;
						} else if (rtPrice[i-coin[j]]+1 < rtPrice[i]){
							rtPrice[i] = rtPrice[i-coin[j]] + 1;
						}
					}
			}
		}
		
		System.out.println(poketMoney - totalPrice + "원의 잔돈을 돌려주기 위한 최소 동전 개수 : " +rtPrice[poketMoney - totalPrice]);
		
	}
}
