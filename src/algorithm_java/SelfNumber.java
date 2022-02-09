package algorithm_java;

//백준 문제풀이
//https://www.acmicpc.net/problem/4673
public class SelfNumber {

	public static void main(String[] args) {
		 
		boolean[] sfNumcheck = new boolean[10001];
 
		for (int i = 1; i < 10001; i++){
			int n = Self(i);
		
			if(n < 10001) {
				sfNumcheck[n] = true;
			}
		}
 
		StringBuilder sb = new StringBuilder();
        
		for (int i = 1; i < 10001; i++) {
			if (!sfNumcheck[i]) {	// false 인 인덱스만 출력
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}
 
 
 
	public static int Self(int number){
		int sum = number;
    
		while(number != 0){
			sum = sum + (number % 10); // 10으로 나눈 나머지 값을 더함, (number의 1의 자리값 추출)
			number = number/10;	// 10을 나누어 나온 몫을 추출, (일의 자리 값 제외시키기)
		}
    
		return sum;
	}
}
