package algorithm_java;

import java.util.Scanner;

public class Z10872 {

	static int result = 1;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		factorial(N);
		System.out.println(result);
		scan.close();
		
	}
	
	public static void factorial(int num){
		if(num == 0){
			result =1;
		} else if (num == 1){
			result = result*num;
		} else {
			result = result*num;
			factorial(num-1);
		}
		
	}
}
