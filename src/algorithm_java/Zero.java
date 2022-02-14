package algorithm_java;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/*
https://www.acmicpc.net/problem/10773
 */
public class Zero {

	public static void main(String[] args) {
		
		//입력단 start
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt(); // 입력받을 K 값
		
		Stack<Integer> stack = new Stack<>();
		
		int inputNum =0;
		
		for(int i =0; i < N; i++) {
			inputNum = scan.nextInt();
			if(inputNum != 0) {
				stack.push(inputNum);
			} else {
				stack.pop();
			}
		}
		
		int totalSum = 0;
		
		Iterator<Integer> iter = stack.iterator(); 
		while(iter.hasNext()) {
			totalSum += iter.next();
		}
		
		System.out.println(totalSum);
	}
}